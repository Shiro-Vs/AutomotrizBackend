package com.automotriz.AutomotrizBackend.Service;

import com.automotriz.AutomotrizBackend.DTO.AsistenciaDTO;
import com.automotriz.AutomotrizBackend.Model.Asistencia;
import com.automotriz.AutomotrizBackend.Model.Horario;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import com.automotriz.AutomotrizBackend.Repository.AsistenciaRepository;
import com.automotriz.AutomotrizBackend.Repository.HorarioRepository;
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
        dto.setId(asistencia.getId()); // <- IMPORTANTE
        dto.setFecha(asistencia.getFecha());
        dto.setHoraEntrada(asistencia.getHoraEntrada());
        dto.setLlegoTarde(asistencia.getLlegoTarde());
        dto.setFalto(asistencia.getFalto());
        dto.setIdTrabajador(asistencia.getTrabajadores().getId_admin());
        return dto;
    }

    // 🔁 Convertir DTO a Entidad
    private Asistencia toEntity(AsistenciaDTO dto) {
        Asistencia asistencia = new Asistencia();
        if (dto.getId() != null) {
            asistencia.setId(dto.getId()); // <- IMPORTANTE
        }
        asistencia.setFecha(dto.getFecha());
        asistencia.setHoraEntrada(dto.getHoraEntrada());
        asistencia.setLlegoTarde(dto.getLlegoTarde());
        asistencia.setFalto(dto.getFalto());

        Optional<Trabajadores> trabajadorOpt = trabajadoresRepository.findById(dto.getIdTrabajador());
        trabajadorOpt.ifPresent(asistencia::setTrabajadores);

        return asistencia;
    }

    @Override
    public List<AsistenciaDTO> listarPorTrabajador(Integer idTrabajador) {
        Optional<Trabajadores> trabajadorOpt = trabajadoresRepository.findById(idTrabajador);
        if (trabajadorOpt.isEmpty())
            return List.of();

        return asistenciaRepository.findByTrabajadores(trabajadorOpt.get())
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsistenciaDTO obtenerPorFecha(Integer idTrabajador, LocalDate fecha) {
        Optional<Trabajadores> trabajadorOpt = trabajadoresRepository.findById(idTrabajador);
        if (trabajadorOpt.isEmpty())
            return null;

        return asistenciaRepository.findByTrabajadoresAndFecha(trabajadorOpt.get(), fecha)
                .map(this::toDTO)
                .orElse(null);
    }

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public String registrar(AsistenciaDTO dto) {
        Optional<Trabajadores> trabajadoresOpt = trabajadoresRepository.findById(dto.getIdTrabajador());

        if (trabajadoresOpt.isEmpty()) {
            return "Trabajador no encontrado.";
        }

        Trabajadores trabajador = trabajadoresOpt.get();

        if (Boolean.FALSE.equals(trabajador.getEstado())) {
            return "El usuario está inactivo.";
        }

        // 👉 Buscar el horario actual del trabajador
        Optional<Horario> horarioOpt = horarioRepository.findByTrabajador(trabajador);
        if (horarioOpt.isEmpty()) {
            return "No se encontró el horario del trabajador.";
        }

        Horario horario = horarioOpt.get();

        // 👉 Verificar si es día de descanso
        String diaSemana = dto.getFecha().getDayOfWeek().toString(); // ej. MONDAY
        if (horario.getDiasDescanso() != null && horario.getDiasDescanso().toUpperCase().contains(diaSemana)) {
            return "Hoy es un día de descanso.";
        }

        // 👉 Comparar hora marcada con hora programada
        boolean llegoTarde = false;
        if (dto.getHoraEntrada().isAfter(horario.getHoraEntrada().plusMinutes(5))) {
            llegoTarde = true;
        }

        // Crear asistencia
        Asistencia asistencia = new Asistencia();
        asistencia.setFecha(dto.getFecha());
        asistencia.setHoraEntrada(dto.getHoraEntrada());
        asistencia.setLlegoTarde(llegoTarde);
        asistencia.setFalto(false); // Si se registra, no faltó
        asistencia.setTrabajadores(trabajador);

        asistenciaRepository.save(asistencia);
        return "Asistencia registrada con éxito.";
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
