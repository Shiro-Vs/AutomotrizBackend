package com.automotriz.backend.service;

import java.util.List;

import com.automotriz.backend.model.FichaTecnica;

public interface FichaTecnicaService {
    List<FichaTecnica> listarTodos();

    FichaTecnica buscarPorId(Integer id);

    void registrar(FichaTecnica ficha);

    void eliminar(Integer id);

    List<FichaTecnica> buscarPorVehiculo(Integer idVehiculo);
}
