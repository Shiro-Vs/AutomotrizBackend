package com.automotriz.backend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.automotriz.backend.dto.TrabajadoresDTO;
import com.automotriz.backend.model.Trabajadores;
import com.automotriz.backend.repository.TrabajadoresRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabajadoresServiceImpl implements TrabajadoresService {

    private final TrabajadoresRepository trabajadoresRepository;

    public TrabajadoresServiceImpl(TrabajadoresRepository trabajadoresRepository) {
        this.trabajadoresRepository = trabajadoresRepository;
    }

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

    @Override
    public List<TrabajadoresDTO> obtenerActivos() {
        List<Trabajadores> trabajadores = trabajadoresRepository.findByEstado(true); // o true si es Boolean

        return trabajadores.stream().map(t -> {
            TrabajadoresDTO dto = new TrabajadoresDTO();
            dto.setId(t.getId_admin()); // ← corrección clave
            dto.setNombre(t.getNombre());
            dto.setDni(t.getDni());
            dto.setCelular(t.getCelular());
            dto.setEmail(t.getEmail());
            dto.setDireccion(t.getDireccion());
            dto.setFechaIngreso(t.getFechaIngreso());
            dto.setFechaRetiro(t.getFechaRetiro());
            dto.setEstado(t.getEstado());
            dto.setRol(t.getRol());
            dto.setContrasenia(t.getContrasenia());
            return dto;
        }).collect(Collectors.toList());
    }

}
