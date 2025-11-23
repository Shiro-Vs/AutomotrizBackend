package com.automotriz.backend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.automotriz.backend.model.Vehiculo;
import com.automotriz.backend.repository.VehiculoRepository;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo buscarPorId(Integer id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public void registrar(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminar(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    public List<Vehiculo> buscarPorCliente(Integer idCliente) {
        return vehiculoRepository.findByCliente_Id(idCliente);
    }
}
