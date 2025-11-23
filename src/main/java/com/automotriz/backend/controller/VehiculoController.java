package com.automotriz.backend.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.automotriz.backend.dto.VehiculoDTO;
import com.automotriz.backend.model.Cliente;
import com.automotriz.backend.model.Vehiculo;
import com.automotriz.backend.service.ClienteService;
import com.automotriz.backend.service.VehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    private final ClienteService clienteService;

    public VehiculoController(VehiculoService vehiculoService, ClienteService clienteService) {
        this.vehiculoService = vehiculoService;
        this.clienteService = clienteService;
    }

    // ✅ Listar todos los vehículos
    @GetMapping
    public List<VehiculoDTO> listarVehiculos() {
        return vehiculoService.listarTodos().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // ✅ Obtener vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> obtenerPorId(@PathVariable Integer id) {
        Vehiculo vehiculo = vehiculoService.buscarPorId(id);
        if (vehiculo != null) {
            return ResponseEntity.ok(convertirADTO(vehiculo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Registrar nuevo vehículo
    @PostMapping
    public ResponseEntity<VehiculoDTO> registrarVehiculo(@RequestBody VehiculoDTO dto) {
        Cliente cliente = clienteService.buscarPorId(dto.getIdCliente());
        if (cliente == null) {
            return ResponseEntity.badRequest().build(); // o puedes devolver mensaje si quieres
        }

        Vehiculo vehiculo = new Vehiculo(
                dto.getPlaca(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getAnio(),
                dto.getColor(),
                dto.getFechaRegistro(),
                cliente);

        vehiculoService.registrar(vehiculo);
        return ResponseEntity.ok(convertirADTO(vehiculo));
    }

    // ✅ Actualizar vehículo existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarVehiculo(@PathVariable Integer id, @RequestBody VehiculoDTO dto) {
        Vehiculo vehiculoExistente = vehiculoService.buscarPorId(id);
        if (vehiculoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        Cliente cliente = clienteService.buscarPorId(dto.getIdCliente());
        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente no encontrado.");
        }

        // Actualizar datos del vehículo
        vehiculoExistente.setPlaca(dto.getPlaca());
        vehiculoExistente.setMarca(dto.getMarca());
        vehiculoExistente.setModelo(dto.getModelo());
        vehiculoExistente.setAnio(dto.getAnio());
        vehiculoExistente.setColor(dto.getColor());
        vehiculoExistente.setFechaRegistro(dto.getFechaRegistro());
        vehiculoExistente.setCliente(cliente);

        vehiculoService.registrar(vehiculoExistente); // reutilizamos registrar para guardar cambios

        return ResponseEntity.ok("Vehículo actualizado correctamente.");
    }

    // ✅ Eliminar vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable Integer id) {
        vehiculoService.eliminar(id);
        return ResponseEntity.ok("Vehículo eliminado correctamente.");
    }

    // ✅ Buscar vehículos por ID de cliente
    @GetMapping("/cliente/{idCliente}")
    public List<VehiculoDTO> listarPorCliente(@PathVariable Integer idCliente) {
        return vehiculoService.buscarPorCliente(idCliente).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // 🔁 Conversión de Entidad a DTO
    private VehiculoDTO convertirADTO(Vehiculo vehiculo) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getIdVehiculo());
        dto.setPlaca(vehiculo.getPlaca());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        dto.setAnio(vehiculo.getAnio());
        dto.setColor(vehiculo.getColor());
        dto.setFechaRegistro(vehiculo.getFechaRegistro());
        dto.setIdCliente(vehiculo.getCliente().getId());
        dto.setNombreCliente(vehiculo.getCliente().getNombre());
        return dto;
    }
}
