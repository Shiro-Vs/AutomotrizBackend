package com.automotriz.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotriz.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Puedes agregar búsquedas por DNI o nombre si lo necesitas
    Cliente findByDni(String dni);
}

