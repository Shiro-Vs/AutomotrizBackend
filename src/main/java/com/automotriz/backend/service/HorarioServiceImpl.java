package com.automotriz.backend.service;

import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.automotriz.backend.dto.HorarioDTO;
import com.automotriz.backend.model.Horario;
import com.automotriz.backend.model.Trabajadores;
import com.automotriz.backend.repository.HorarioRepository;
import com.automotriz.backend.repository.TrabajadoresRepository;

import jakarta.transaction.Transactional;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository horarioRepository;

    private final TrabajadoresRepository trabajadoresRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository, TrabajadoresRepository trabajadoresRepository) {
        this.horarioRepository = horarioRepository;
        this.trabajadoresRepository = trabajadoresRepository;
    }

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
