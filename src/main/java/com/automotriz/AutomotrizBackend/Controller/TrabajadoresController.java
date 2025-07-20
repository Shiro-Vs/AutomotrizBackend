package com.automotriz.AutomotrizBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.automotriz.AutomotrizBackend.DTO.TrabajadoresDTO;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import com.automotriz.AutomotrizBackend.Service.TrabajadoresService;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadoresController {

    @Autowired
    private TrabajadoresService trabajadoresService;

    // ✅ Listar todos como DTOs
    @GetMapping
    public List<TrabajadoresDTO> listarTrabajadores() {
        return trabajadoresService.listarTodos()
                .stream()
                .map(t -> {
                    TrabajadoresDTO dto = new TrabajadoresDTO();
                    dto.setId(t.getId_admin());
                    dto.setNombre(t.getNombre());
                    dto.setDni(t.getDni());
                    dto.setCelular(t.getCelular());
                    dto.setEmail(t.getEmail());
                    dto.setDireccion(t.getDireccion());
                    dto.setFechaIngreso(t.getFechaIngreso());
                    dto.setFechaRetiro(t.getFechaRetiro());
                    dto.setEstado(t.getEstado());
                    dto.setRol(t.getRol());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // ✅ Registrar un nuevo trabajador desde DTO
    @PostMapping
    public ResponseEntity<String> registrarTrabajador(@RequestBody TrabajadoresDTO dto) {
        Trabajadores trabajador = new Trabajadores();
        trabajador.setId_admin(dto.getId()); // puede ser null para autogenerar
        trabajador.setNombre(dto.getNombre());
        trabajador.setDni(dto.getDni());
        trabajador.setCelular(dto.getCelular());
        trabajador.setEmail(dto.getEmail());
        trabajador.setDireccion(dto.getDireccion());
        trabajador.setFechaIngreso(dto.getFechaIngreso());
        trabajador.setFechaRetiro(dto.getFechaRetiro());
        trabajador.setEstado(dto.getEstado());
        trabajador.setRol(dto.getRol());
        trabajador.setContrasenia(dto.getContrasenia()); // ⚠️ En siguiente paso debes encriptarla

        trabajadoresService.registrar(trabajador);
        return ResponseEntity.ok("Trabajador registrado correctamente.");
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody TrabajadoresDTO dto) {
        String dni = dto.getDni();
        String contrasenia = dto.getContrasenia();

        Trabajadores trabajador = trabajadoresService.buscarPorDni(dni);

        if (trabajador == null) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        if (!trabajador.getContrasenia().equals(contrasenia)) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        // Normalizamos el rol para evitar errores por mayúsculas/tildes
        String rolOriginal = trabajador.getRol();
        String rol = Normalizer.normalize(rolOriginal, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "") // elimina acentos
                .toLowerCase(Locale.ROOT);

        if (!rol.equals("administrador") && !rol.equals("mecanico")) {
            return ResponseEntity.status(403).body(
                    Map.of("error", "Acceso restringido solo a administradores o mecánicos"));
        }

        // Devuelve solo los datos necesarios
        TrabajadoresDTO responseDTO = new TrabajadoresDTO();
        responseDTO.setId(trabajador.getId_admin());
        responseDTO.setNombre(trabajador.getNombre());
        responseDTO.setRol(trabajador.getRol());

        return ResponseEntity.ok(responseDTO);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadoresDTO> obtenerPorId(@PathVariable Integer id) {
        Trabajadores t = trabajadoresService.buscarPorId(id);
        if (t != null) {
            TrabajadoresDTO dto = new TrabajadoresDTO();
            dto.setId(t.getId_admin());
            dto.setNombre(t.getNombre());
            dto.setDni(t.getDni());
            dto.setCelular(t.getCelular());
            dto.setEmail(t.getEmail());
            dto.setDireccion(t.getDireccion());
            dto.setFechaIngreso(t.getFechaIngreso());
            dto.setFechaRetiro(t.getFechaRetiro());
            dto.setEstado(t.getEstado());
            dto.setRol(t.getRol());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Actualizar trabajador
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTrabajador(@PathVariable Integer id, @RequestBody TrabajadoresDTO dto) {
        Trabajadores existente = trabajadoresService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar campos
        existente.setNombre(dto.getNombre());
        existente.setDni(dto.getDni());
        existente.setCelular(dto.getCelular());
        existente.setEmail(dto.getEmail());
        existente.setDireccion(dto.getDireccion());
        existente.setFechaIngreso(dto.getFechaIngreso());
        existente.setFechaRetiro(dto.getFechaRetiro());
        existente.setEstado(dto.getEstado());
        existente.setRol(dto.getRol());

        if (dto.getContrasenia() != null && !dto.getContrasenia().trim().isEmpty()) {
            existente.setContrasenia(dto.getContrasenia()); // ⚠️ Recuerda encriptar si es necesario
        }

        trabajadoresService.registrar(existente); // se usa registrar para guardar cambios
        return ResponseEntity.ok("Trabajador actualizado correctamente.");
    }

    // ✅ Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTrabajador(@PathVariable Integer id) {
        try {
            trabajadoresService.eliminar(id);
            return ResponseEntity.ok("Trabajador eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(400)
                    .body("No se puede eliminar el trabajador porque tiene clientes relacionados.");
        }
    }

    @GetMapping("/activos")
    public ResponseEntity<List<TrabajadoresDTO>> obtenerTrabajadoresActivos() {
        List<TrabajadoresDTO> trabajadores = trabajadoresService.obtenerActivos();
        return ResponseEntity.ok(trabajadores);
    }

}
