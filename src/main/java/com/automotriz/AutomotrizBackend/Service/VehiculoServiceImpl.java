package com.automotriz.AutomotrizBackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotriz.AutomotrizBackend.Model.Vehiculo;
import com.automotriz.AutomotrizBackend.Repository.VehiculoRepository;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

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
