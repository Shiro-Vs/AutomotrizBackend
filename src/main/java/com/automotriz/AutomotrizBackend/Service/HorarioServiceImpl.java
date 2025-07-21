package com.automotriz.AutomotrizBackend.Service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotriz.AutomotrizBackend.DTO.HorarioDTO;
import com.automotriz.AutomotrizBackend.Model.Horario;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import com.automotriz.AutomotrizBackend.Repository.HorarioRepository;
import com.automotriz.AutomotrizBackend.Repository.TrabajadoresRepository;

import jakarta.transaction.Transactional;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private TrabajadoresRepository trabajadoresRepository;

    @Override
    @Transactional
    public void guardarOHorActualizar(HorarioDTO dto) {
        LocalTime entrada = dto.getHoraEntrada();
        LocalTime salida = dto.getHoraSalida();

        actualizarHorario(dto.getIdTrabajador(), entrada, salida, dto.getDiasDescanso());
    }

    @Override
    public Horario actualizarHorario(Integer idTrabajador, LocalTime entrada, LocalTime salida, String descanso) {
        Trabajadores trabajador = trabajadoresRepository.findById(idTrabajador)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));

        Horario horario = horarioRepository.findByTrabajador(trabajador)
                .orElseGet(() -> {
                    Horario nuevoHorario = new Horario();
                    nuevoHorario.setTrabajador(trabajador);
                    return nuevoHorario;
                });

        horario.setHoraEntrada(entrada);
        horario.setHoraSalida(salida);
        horario.setDiasDescanso(descanso);

        return horarioRepository.save(horario);
    }

    @Override
    public HorarioDTO obtenerHorario(Integer idTrabajador) {
        Trabajadores trabajador = trabajadoresRepository.findById(idTrabajador)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));

        Horario horario = horarioRepository.findByTrabajador(trabajador)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));

        // Convertir a DTO
        HorarioDTO dto = new HorarioDTO();
        dto.setIdTrabajador(trabajador.getId_admin()); // O getIdTrabajador() si se llama así
        dto.setHoraEntrada(horario.getHoraEntrada());
        dto.setHoraSalida(horario.getHoraSalida());
        dto.setDiasDescanso(horario.getDiasDescanso());

        return dto;
    }

}
