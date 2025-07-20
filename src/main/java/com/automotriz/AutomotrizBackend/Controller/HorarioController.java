package com.automotriz.AutomotrizBackend.Controller;

import com.automotriz.AutomotrizBackend.DTO.HorarioDTO;
import com.automotriz.AutomotrizBackend.Service.HorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@CrossOrigin(origins = "*")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/trabajador/{idTrabajador}")
    public List<HorarioDTO> listarPorTrabajador(@PathVariable Integer idTrabajador) {
        return horarioService.listarPorTrabajador(idTrabajador);
    }

    @PostMapping
    public HorarioDTO registrar(@RequestBody HorarioDTO horarioDTO) {
        return horarioService.registrar(horarioDTO);
    }

    @PutMapping("/{id}")
    public HorarioDTO actualizar(@PathVariable Integer id, @RequestBody HorarioDTO horarioDTO) {
        horarioDTO.setId(id);
        return horarioService.actualizar(horarioDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        horarioService.eliminar(id);
    }
}

