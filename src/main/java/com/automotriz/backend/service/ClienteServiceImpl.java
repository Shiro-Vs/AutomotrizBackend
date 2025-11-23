package com.automotriz.backend.service;

import org.springframework.stereotype.Service;

import com.automotriz.backend.model.Cliente;
import com.automotriz.backend.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void registrar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        // Usamos save porque en JPA actualiza si el ID ya existe
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
