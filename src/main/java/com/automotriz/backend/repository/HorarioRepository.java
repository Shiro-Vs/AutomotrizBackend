package com.automotriz.backend.repository;

import com.automotriz.backend.model.Horario;
import com.automotriz.backend.model.Trabajadores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    Optional<Horario> findByTrabajador(Trabajadores trabajador);
}

