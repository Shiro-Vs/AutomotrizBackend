package com.automotriz.backend.repository;

import com.automotriz.backend.model.Asistencia;
import com.automotriz.backend.model.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    // Buscar todas las asistencias de un trabajador
    List<Asistencia> findByTrabajadores(Trabajadores trabajadores);
    // Buscar asistencia de un trabajador por fecha
    Optional<Asistencia> findByTrabajadoresAndFecha(Trabajadores trabajadores, LocalDate fecha);
}

