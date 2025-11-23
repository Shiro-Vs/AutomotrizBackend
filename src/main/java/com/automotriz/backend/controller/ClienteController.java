package com.automotriz.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.automotriz.backend.dto.ClienteDTO;
import com.automotriz.backend.model.Cliente;
import com.automotriz.backend.service.ClienteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // ✅ Listar todos
    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarTodos()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // ✅ Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(convertirADTO(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Registrar cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setDni(dto.getDni());
        cliente.setCelular(dto.getCelular());
        cliente.setEmail(dto.getEmail());
        cliente.setDireccion(dto.getDireccion());

        clienteService.registrar(cliente);

        return ResponseEntity.ok(convertirADTO(cliente));
    }

    // ✅ Actualizar cliente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Integer id, @RequestBody ClienteDTO dto) {
        Cliente existente = clienteService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNombre(dto.getNombre());
        existente.setDni(dto.getDni());
        existente.setCelular(dto.getCelular());
        existente.setEmail(dto.getEmail());
        existente.setDireccion(dto.getDireccion());

        clienteService.actualizar(existente);
        return ResponseEntity.ok("Cliente actualizado correctamente.");
    }

    // ✅ Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity.ok("Cliente eliminado correctamente.");
    }

    // 🔁 Convertir modelo a DTO
    private ClienteDTO convertirADTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setDni(cliente.getDni());
        dto.setCelular(cliente.getCelular());
        dto.setEmail(cliente.getEmail());
        dto.setDireccion(cliente.getDireccion());
        return dto;
    }
}
