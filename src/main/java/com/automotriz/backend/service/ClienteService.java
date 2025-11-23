package com.automotriz.backend.service;

import java.util.List;

import com.automotriz.backend.model.Cliente;

public interface ClienteService {
    List<Cliente> listarTodos();

    Cliente buscarPorId(Integer id);

    void registrar(Cliente cliente);

    void actualizar(Cliente cliente);

    void eliminar(Integer id);
}
