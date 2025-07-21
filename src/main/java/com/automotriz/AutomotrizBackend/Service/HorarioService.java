package com.automotriz.AutomotrizBackend.Service;

import java.time.LocalTime;

import com.automotriz.AutomotrizBackend.DTO.HorarioDTO;
import com.automotriz.AutomotrizBackend.Model.Horario;

public interface HorarioService {
    void guardarOHorActualizar(HorarioDTO horarioDTO);
    Horario actualizarHorario(Integer idTrabajador, LocalTime entrada, LocalTime salida, String descanso);
    HorarioDTO obtenerHorario(Integer idTrabajador);
}
