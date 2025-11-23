package com.automotriz.backend.service;

import com.automotriz.backend.dto.AsistenciaDTO;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaService {
    List<AsistenciaDTO> listarPorTrabajador(Integer idTrabajador);

    AsistenciaDTO obtenerPorFecha(Integer idTrabajador, LocalDate fecha);

    String registrar(AsistenciaDTO asistenciaDTO);

    AsistenciaDTO actualizar(AsistenciaDTO asistenciaDTO);

    void eliminar(Integer id);
}
