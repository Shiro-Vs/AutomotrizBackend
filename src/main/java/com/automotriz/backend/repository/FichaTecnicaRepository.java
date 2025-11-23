package com.automotriz.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotriz.backend.model.FichaTecnica;

import java.util.List;

public interface FichaTecnicaRepository extends JpaRepository<FichaTecnica, Integer> {
    List<FichaTecnica> findByVehiculoIdVehiculo(Integer idVehiculo);
}

