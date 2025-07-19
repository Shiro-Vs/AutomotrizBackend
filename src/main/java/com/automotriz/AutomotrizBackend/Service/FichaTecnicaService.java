package com.automotriz.AutomotrizBackend.Service;

import java.util.List;

import com.automotriz.AutomotrizBackend.Model.FichaTecnica;

public interface FichaTecnicaService {
    List<FichaTecnica> listarTodos();
    FichaTecnica buscarPorId(Integer id);
    void registrar(FichaTecnica ficha);
    void eliminar(Integer id);
    List<FichaTecnica> buscarPorVehiculo(Integer idVehiculo);
}
