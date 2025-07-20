package com.automotriz.AutomotrizBackend.Controller;

import com.automotriz.AutomotrizBackend.DTO.AsistenciaDTO;
import com.automotriz.AutomotrizBackend.Service.AsistenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/trabajador/{idTrabajador}")
    public List<AsistenciaDTO> listarPorTrabajador(@PathVariable Integer idTrabajador) {
        return asistenciaService.listarPorTrabajador(idTrabajador);
    }

    @GetMapping("/trabajador/{idTrabajador}/fecha/{fecha}")
    public AsistenciaDTO obtenerPorFecha(@PathVariable Integer idTrabajador, @PathVariable String fecha) {
        return asistenciaService.obtenerPorFecha(idTrabajador, LocalDate.parse(fecha));
    }

    @PostMapping
    public AsistenciaDTO registrar(@RequestBody AsistenciaDTO asistenciaDTO) {
        return asistenciaService.registrar(asistenciaDTO);
    }

    @PutMapping("/{id}")
    public AsistenciaDTO actualizar(@PathVariable Integer id, @RequestBody AsistenciaDTO asistenciaDTO) {
        asistenciaDTO.setId(id);
        return asistenciaService.actualizar(asistenciaDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        asistenciaService.eliminar(id);
    }
}
