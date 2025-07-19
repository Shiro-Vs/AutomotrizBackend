package com.automotriz.AutomotrizBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotriz.AutomotrizBackend.Model.FichaTecnica;

import java.util.List;

public interface FichaTecnicaRepository extends JpaRepository<FichaTecnica, Integer> {
    List<FichaTecnica> findByVehiculoIdVehiculo(Integer idVehiculo);
}
