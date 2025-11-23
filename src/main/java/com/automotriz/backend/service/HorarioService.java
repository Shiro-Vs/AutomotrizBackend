package com.automotriz.backend.service;

import java.time.LocalTime;

import com.automotriz.backend.dto.HorarioDTO;
import com.automotriz.backend.model.Horario;

public interface HorarioService {
    void guardarOHorActualizar(HorarioDTO horarioDTO);

    Horario actualizarHorario(Integer idTrabajador, LocalTime entrada, LocalTime salida, String descanso);

    HorarioDTO obtenerHorario(Integer idTrabajador);
}
