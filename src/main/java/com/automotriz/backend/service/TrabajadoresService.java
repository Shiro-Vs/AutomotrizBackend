package com.automotriz.backend.service;

import java.util.List;

import com.automotriz.backend.dto.TrabajadoresDTO;
import com.automotriz.backend.model.Trabajadores;

public interface TrabajadoresService {
    List<Trabajadores> listarTodos();

    void registrar(Trabajadores trabajador);

    Trabajadores buscarPorId(Integer id);

    void eliminar(Integer id);

    Trabajadores buscarPorDni(String dni);

    List<TrabajadoresDTO> obtenerActivos();
}
