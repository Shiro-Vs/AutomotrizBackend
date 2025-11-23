package com.automotriz.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotriz.backend.model.Vehiculo;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Ejemplo de métodos adicionales:
    List<Vehiculo> findByPlacaContainingIgnoreCase(String placa);
    
    List<Vehiculo> findByCliente_Id(Integer idCliente);
}

