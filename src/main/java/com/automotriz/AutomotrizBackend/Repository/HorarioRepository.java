package com.automotriz.AutomotrizBackend.Repository;

import com.automotriz.AutomotrizBackend.Model.Horario;
import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    // Buscar el horario por trabajador
    Optional<Horario> findByTrabajador(Trabajadores trabajador);
}
