package com.automotriz.AutomotrizBackend.Service;

import java.util.List;

import com.automotriz.AutomotrizBackend.Model.Trabajadores;

public interface TrabajadoresService {
    List<Trabajadores> listarTodos();
    void registrar(Trabajadores trabajador);
    Trabajadores buscarPorId(Integer id);
    void eliminar(Integer id);
}
