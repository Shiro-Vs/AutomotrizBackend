package com.automotriz.AutomotrizBackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotriz.AutomotrizBackend.Model.Trabajadores;
import com.automotriz.AutomotrizBackend.Repository.TrabajadoresRepository;

import java.util.List;

@Service
public class TrabajadoresServiceImpl implements TrabajadoresService {

    @Autowired
    private TrabajadoresRepository trabajadoresRepository;

    @Override
    public List<Trabajadores> listarTodos() {
        return trabajadoresRepository.findAll();
    }

    @Override
    public void registrar(Trabajadores trabajador) {
        trabajadoresRepository.save(trabajador);
    }

    @Override
    public Trabajadores buscarPorId(Integer id) {
        return trabajadoresRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        trabajadoresRepository.deleteById(id);
    }

    @Override
    public Trabajadores buscarPorDni(String dni) {
        return trabajadoresRepository.findByDni(dni);
    }

}
