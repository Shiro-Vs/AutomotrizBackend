package com.automotriz.AutomotrizBackend.Service;

import java.util.List;

import com.automotriz.AutomotrizBackend.Model.Cliente;

public interface ClienteService {
    List<Cliente> listarTodos();
    Cliente buscarPorId(Integer id);
    void registrar(Cliente cliente);
    void actualizar(Cliente cliente); 
    void eliminar(Integer id);
}
