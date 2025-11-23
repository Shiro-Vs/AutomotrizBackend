package com.automotriz.backend.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.automotriz.backend.dto.FichaTecnicaDTO;
import com.automotriz.backend.model.FichaTecnica;
import com.automotriz.backend.model.Vehiculo;
import com.automotriz.backend.repository.VehiculoRepository;
import com.automotriz.backend.service.FichaTecnicaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fichas-tecnicas")
public class FichaTecnicaController {

    private final FichaTecnicaService fichaTecnicaService;

    private final VehiculoRepository vehiculoRepository;

    public FichaTecnicaController(FichaTecnicaService fichaTecnicaService, VehiculoRepository vehiculoRepository) {
        this.fichaTecnicaService = fichaTecnicaService;
        this.vehiculoRepository = vehiculoRepository;
    }

    // ✅ Listar todas las fichas técnicas
    @GetMapping
    public List<FichaTecnicaDTO> listarTodas() {
        return fichaTecnicaService.listarTodos().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<FichaTecnicaDTO> obtenerPorId(@PathVariable Integer id) {
        FichaTecnica ficha = fichaTecnicaService.buscarPorId(id);
        if (ficha == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(convertirADTO(ficha));
    }

    // ✅ Buscar por vehículo
    @GetMapping("/vehiculo/{idVehiculo}")
    public List<FichaTecnicaDTO> fichasPorVehiculo(@PathVariable Integer idVehiculo) {
        return fichaTecnicaService.buscarPorVehiculo(idVehiculo).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // ✅ Registrar nueva ficha
    @PostMapping
    public ResponseEntity<String> registrarFicha(@RequestBody FichaTecnicaDTO dto) {
        Vehiculo vehiculo = vehiculoRepository.findById(dto.getIdVehiculo()).orElse(null);
        if (vehiculo == null) {
            return ResponseEntity.badRequest().body("Vehículo no encontrado.");
        }

        FichaTecnica ficha = new FichaTecnica();
        ficha.setObservaciones(dto.getObservaciones());
        ficha.setDiagnosticoInicial(dto.getDiagnosticoInicial());
        ficha.setServicios(dto.getServicios());
        ficha.setRepuestos(dto.getRepuestos());
        ficha.setFIngreso(dto.getFIngreso());
        ficha.setFSalida(dto.getFSalida());
        ficha.setEstado(dto.getEstado());
        ficha.setVehiculo(vehiculo);

        fichaTecnicaService.registrar(ficha);
        return ResponseEntity.ok("Ficha técnica registrada.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarFicha(@PathVariable Integer id, @RequestBody FichaTecnicaDTO dto) {
        FichaTecnica fichaExistente = fichaTecnicaService.buscarPorId(id);
        if (fichaExistente == null) {
            return ResponseEntity.notFound().build();
        }

        Vehiculo vehiculo = vehiculoRepository.findById(dto.getIdVehiculo()).orElse(null);
        if (vehiculo == null) {
            return ResponseEntity.badRequest().body("Vehículo no encontrado.");
        }

        // Actualizar los campos de la ficha existente
        fichaExistente.setObservaciones(dto.getObservaciones());
        fichaExistente.setDiagnosticoInicial(dto.getDiagnosticoInicial());
        fichaExistente.setServicios(dto.getServicios());
        fichaExistente.setRepuestos(dto.getRepuestos());
        fichaExistente.setFIngreso(dto.getFIngreso());
        fichaExistente.setFSalida(dto.getFSalida());
        fichaExistente.setEstado(dto.getEstado());
        fichaExistente.setVehiculo(vehiculo);

        fichaTecnicaService.registrar(fichaExistente); // Reutilizas el mismo método para guardar

        return ResponseEntity.ok("Ficha técnica actualizada.");
    }

    // ✅ Eliminar ficha técnica
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFicha(@PathVariable Integer id) {
        fichaTecnicaService.eliminar(id);
        return ResponseEntity.ok("Ficha técnica eliminada.");
    }

    // 🔄 Convertir a DTO
    private FichaTecnicaDTO convertirADTO(FichaTecnica ficha) {
        FichaTecnicaDTO dto = new FichaTecnicaDTO();
        dto.setId(ficha.getId());
        dto.setObservaciones(ficha.getObservaciones());
        dto.setDiagnosticoInicial(ficha.getDiagnosticoInicial());
        dto.setServicios(ficha.getServicios());
        dto.setRepuestos(ficha.getRepuestos());
        dto.setFIngreso(ficha.getFIngreso());
        dto.setFSalida(ficha.getFSalida());
        dto.setEstado(ficha.getEstado());

        // Vehículo
        Vehiculo vehiculo = ficha.getVehiculo();
        if (vehiculo != null) {
            dto.setIdVehiculo(vehiculo.getIdVehiculo());
            dto.setPlacaVehiculo(vehiculo.getPlaca());
            dto.setMarcaVehiculo(vehiculo.getMarca());
            dto.setColorVehiculo(vehiculo.getColor());

            if (vehiculo.getCliente() != null) {
                dto.setNombreCliente(vehiculo.getCliente().getNombre());
            } else {
                dto.setNombreCliente("Sin cliente");
            }

        }

        return dto;
    }

}
