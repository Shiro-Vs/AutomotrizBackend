package com.automotriz.AutomotrizBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotriz.AutomotrizBackend.Model.Trabajadores;

public interface TrabajadoresRepository extends JpaRepository<Trabajadores, Integer> {
    // Más adelante puedes agregar: findByDni(), findByEmail(), etc.
    Trabajadores findByDni(String dni);
}
