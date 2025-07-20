package com.automotriz.AutomotrizBackend.Service;

import com.automotriz.AutomotrizBackend.DTO.HorarioDTO;
import com.automotriz.AutomotrizBackend.Model.Horario;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import com.automotriz.AutomotrizBackend.Repository.HorarioRepository;
import com.automotriz.AutomotrizBackend.Repository.TrabajadoresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private TrabajadoresRepository trabajadorRepository;

    @Override
    public HorarioDTO registrar(HorarioDTO dto) {
        Horario horario = new Horario();
        Trabajadores trabajador = trabajadorRepository.findById(dto.getIdTrabajador()).orElseThrow();

        horario.setTrabajador(trabajador);
        horario.setHoraEntrada(dto.getHoraEntrada());
        horario.setHoraSalida(dto.getHoraSalida());
        horario.setDiasTrabajo(dto.getDiasTrabajo());
        horario.setDiasDescanso(dto.getDiasDescanso());

        horario = horarioRepository.save(horario);

        return toDTO(horario);
    }

    @Override
    public HorarioDTO actualizar(HorarioDTO dto) {
        Horario horario = horarioRepository.findById(dto.getId()).orElseThrow();

        horario.setHoraEntrada(dto.getHoraEntrada());
        horario.setHoraSalida(dto.getHoraSalida());
        horario.setDiasTrabajo(dto.getDiasTrabajo());
        horario.setDiasDescanso(dto.getDiasDescanso());

        horario = horarioRepository.save(horario);

        return toDTO(horario);
    }

    @Override
    public List<HorarioDTO> listarPorTrabajador(Integer idTrabajador) {
        Trabajadores trabajador = trabajadorRepository.findById(idTrabajador).orElseThrow();
        Optional<Horario> optionalHorario = horarioRepository.findByTrabajador(trabajador);

        if (optionalHorario.isPresent()) {
            return Collections.singletonList(toDTO(optionalHorario.get()));
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void eliminar(Integer id) {
        horarioRepository.deleteById(id);
    }

    private HorarioDTO toDTO(Horario h) {
        HorarioDTO dto = new HorarioDTO();
        dto.setId(h.getId());
        dto.setIdTrabajador(h.getTrabajador().getId_admin());
        dto.setHoraEntrada(h.getHoraEntrada());
        dto.setHoraSalida(h.getHoraSalida());
        dto.setDiasTrabajo(h.getDiasTrabajo());
        dto.setDiasDescanso(h.getDiasDescanso());
        return dto;
    }
}
