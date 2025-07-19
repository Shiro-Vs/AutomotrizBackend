package com.automotriz.AutomotrizBackend.Service;

import org.springframework.stereotype.Service;

import com.automotriz.AutomotrizBackend.Model.Cliente;
import com.automotriz.AutomotrizBackend.Repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

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

