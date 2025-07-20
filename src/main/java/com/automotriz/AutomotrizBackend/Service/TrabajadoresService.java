package com.automotriz.AutomotrizBackend.Service;

import java.util.List;

import com.automotriz.AutomotrizBackend.DTO.TrabajadoresDTO;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;

public interface TrabajadoresService {
    List<Trabajadores> listarTodos();
    void registrar(Trabajadores trabajador);
    Trabajadores buscarPorId(Integer id);
    void eliminar(Integer id);
    Trabajadores buscarPorDni(String dni);
     List<TrabajadoresDTO> obtenerActivos();
}
