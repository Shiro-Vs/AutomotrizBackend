package com.automotriz.AutomotrizBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotriz.AutomotrizBackend.Model.Vehiculo;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Ejemplo de métodos adicionales:
    List<Vehiculo> findByPlacaContainingIgnoreCase(String placa);
    
    List<Vehiculo> findByCliente_Id(Integer idCliente);
}
