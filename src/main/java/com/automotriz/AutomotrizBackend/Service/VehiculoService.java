package com.automotriz.AutomotrizBackend.Service;

import java.util.List;

import com.automotriz.AutomotrizBackend.Model.Vehiculo;

public interface VehiculoService {
    List<Vehiculo> listarTodos();
    Vehiculo buscarPorId(Integer id);
    void registrar(Vehiculo vehiculo);
    void eliminar(Integer id);
    List<Vehiculo> buscarPorCliente(Integer idCliente);
}
