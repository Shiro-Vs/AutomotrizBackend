package com.automotriz.backend.service;

import java.util.List;

import com.automotriz.backend.model.Vehiculo;

public interface VehiculoService {
    List<Vehiculo> listarTodos();

    Vehiculo buscarPorId(Integer id);

    void registrar(Vehiculo vehiculo);

    void eliminar(Integer id);

    List<Vehiculo> buscarPorCliente(Integer idCliente);
}
