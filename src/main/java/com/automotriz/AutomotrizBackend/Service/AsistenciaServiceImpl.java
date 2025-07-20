package com.automotriz.AutomotrizBackend.Service;

import com.automotriz.AutomotrizBackend.DTO.AsistenciaDTO;
import com.automotriz.AutomotrizBackend.Model.Asistencia;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import com.automotriz.AutomotrizBackend.Repository.AsistenciaRepository;
import com.automotriz.AutomotrizBackend.Repository.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private TrabajadoresRepository trabajadoresRepository;

    // 🔁 Convertir Entidad a DTO
    private AsistenciaDTO toDTO(Asistencia asistencia) {
        AsistenciaDTO dto = new AsistenciaDTO();
        dto.setId(asistencia.getId());
        dto.setFecha(asistencia.getFecha());
        dto.setHoraEntrada(asistencia.getHoraEntrada());
        dto.setHoraSalida(asistencia.getHoraSalida());
        dto.setIdTrabajador(asistencia.getTrabajadores().getId_admin());
        return dto;
    }

    // 🔁 Convertir DTO a Entidad
    private Asistencia toEntity(AsistenciaDTO dto) {
        Asistencia asistencia = new Asistencia();
        asistencia.setId(dto.getId());
        asistencia.setFecha(dto.getFecha());
        asistencia.setHoraEntrada(dto.getHoraEntrada());
        asistencia.setHoraSalida(dto.getHoraSalida());

        Optional<Trabajadores> trabajadorOpt = trabajadoresRepository.findById(dto.getIdTrabajador());
        trabajadorOpt.ifPresent(asistencia::setTrabajadores);

        return asistencia;
    }

    @Override
    public List<AsistenciaDTO> listarPorTrabajador(Integer idTrabajador) {
        Optional<Trabajadores> trabajadorOpt = trabajadoresRepository.findById(idTrabajador);
        if (trabajadorOpt.isEmpty()) return List.of();

        return asistenciaRepository.findByTrabajadores(trabajadorOpt.get())
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsistenciaDTO obtenerPorFecha(Integer idTrabajador, LocalDate fecha) {
        Optional<Trabajadores> trabajadorOpt = trabajadoresRepository.findById(idTrabajador);
        if (trabajadorOpt.isEmpty()) return null;

        return asistenciaRepository.findByTrabajadoresAndFecha(trabajadorOpt.get(), fecha)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public AsistenciaDTO registrar(AsistenciaDTO asistenciaDTO) {
        Asistencia asistencia = toEntity(asistenciaDTO);
        Asistencia guardado = asistenciaRepository.save(asistencia);
        return toDTO(guardado);
    }

    @Override
    public AsistenciaDTO actualizar(AsistenciaDTO asistenciaDTO) {
        Asistencia asistencia = toEntity(asistenciaDTO);
        Asistencia actualizado = asistenciaRepository.save(asistencia);
        return toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        asistenciaRepository.deleteById(id);
    }
}
