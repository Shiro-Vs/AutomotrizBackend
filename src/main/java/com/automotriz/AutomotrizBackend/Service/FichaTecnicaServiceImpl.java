package com.automotriz.AutomotrizBackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automotriz.AutomotrizBackend.Model.FichaTecnica;
import com.automotriz.AutomotrizBackend.Repository.FichaTecnicaRepository;

import java.util.List;

@Service
public class FichaTecnicaServiceImpl implements FichaTecnicaService {

    @Autowired
    private FichaTecnicaRepository fichaTecnicaRepository;

    @Override
    public List<FichaTecnica> listarTodos() {
        return fichaTecnicaRepository.findAll();
    }

    @Override
    public FichaTecnica buscarPorId(Integer id) {
        return fichaTecnicaRepository.findById(id).orElse(null);
    }

    @Override
    public void registrar(FichaTecnica ficha) {
        fichaTecnicaRepository.save(ficha);
    }

    @Override
    public void eliminar(Integer id) {
        fichaTecnicaRepository.deleteById(id);
    }

    @Override
    public List<FichaTecnica> buscarPorVehiculo(Integer idVehiculo) {
        return fichaTecnicaRepository.findByVehiculoIdVehiculo(idVehiculo);
    }
}
