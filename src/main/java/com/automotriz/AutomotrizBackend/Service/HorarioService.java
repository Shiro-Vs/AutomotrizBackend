package com.automotriz.AutomotrizBackend.Service;

import com.automotriz.AutomotrizBackend.DTO.HorarioDTO;
import java.util.List;

public interface HorarioService {
    HorarioDTO registrar(HorarioDTO horarioDTO);
    HorarioDTO actualizar(HorarioDTO horarioDTO);
    List<HorarioDTO> listarPorTrabajador(Integer idTrabajador);
    void eliminar(Integer id);
}
