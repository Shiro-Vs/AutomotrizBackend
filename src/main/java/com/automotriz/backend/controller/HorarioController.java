package com.automotriz.backend.controller;

import lombok.RequiredArgsConstructor;

import com.automotriz.backend.dto.HorarioDTO;
import com.automotriz.backend.service.HorarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarHorario(@RequestBody HorarioDTO dto) {
        horarioService.guardarOHorActualizar(dto);
        return ResponseEntity.ok("Horario registrado o actualizado con éxito");
    }

    @GetMapping("/trabajador/{idTrabajador}")
    public ResponseEntity<HorarioDTO> obtenerHorarioPorTrabajador(@PathVariable Integer idTrabajador) {
        return ResponseEntity.ok(horarioService.obtenerHorario(idTrabajador));
    }

}
