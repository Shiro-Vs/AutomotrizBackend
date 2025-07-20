package com.automotriz.AutomotrizBackend.Service;

import com.automotriz.AutomotrizBackend.DTO.AsistenciaDTO;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaService {
    List<AsistenciaDTO> listarPorTrabajador(Integer idTrabajador);
    AsistenciaDTO obtenerPorFecha(Integer idTrabajador, LocalDate fecha);
    String registrar(AsistenciaDTO asistenciaDTO);
    AsistenciaDTO actualizar(AsistenciaDTO asistenciaDTO);
    void eliminar(Integer id);
}
