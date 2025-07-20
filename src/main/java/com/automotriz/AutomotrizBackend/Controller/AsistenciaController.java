package com.automotriz.AutomotrizBackend.Controller;

import com.automotriz.AutomotrizBackend.DTO.AsistenciaDTO;
import com.automotriz.AutomotrizBackend.Service.AsistenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*") // Opcional si usas frontend separado
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    // Listar asistencias de un trabajador
    @GetMapping("/trabajador/{idTrabajador}")
    public List<AsistenciaDTO> listarPorTrabajador(@PathVariable Integer idTrabajador) {
        return asistenciaService.listarPorTrabajador(idTrabajador);
    }

    // Obtener asistencia de una fecha específica
    @GetMapping("/trabajador/{idTrabajador}/fecha/{fecha}")
    public AsistenciaDTO obtenerPorFecha(
            @PathVariable Integer idTrabajador,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return asistenciaService.obtenerPorFecha(idTrabajador, fecha);
    }

    // Obtener asistencia del día actual
    @GetMapping("/trabajador/{idTrabajador}/fecha/hoy")
    public AsistenciaDTO obtenerHoy(@PathVariable Integer idTrabajador) {
        return asistenciaService.obtenerPorFecha(idTrabajador, LocalDate.now());
    }

    // Registrar nueva asistencia
    @PostMapping
    public String registrar(@RequestBody AsistenciaDTO asistenciaDTO) {
        return asistenciaService.registrar(asistenciaDTO);  
    }

    // Actualizar asistencia
    @PutMapping("/{id}")
    public AsistenciaDTO actualizar(@PathVariable Integer id, @RequestBody AsistenciaDTO asistenciaDTO) {
        asistenciaDTO.setId(id);
        return asistenciaService.actualizar(asistenciaDTO);
    }

    // Eliminar asistencia
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        asistenciaService.eliminar(id);
    }
}
