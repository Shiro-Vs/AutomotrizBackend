package com.automotriz.AutomotrizBackend.Repository;

import com.automotriz.AutomotrizBackend.Model.Horario;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    Optional<Horario> findByTrabajador(Trabajadores trabajador);
}
