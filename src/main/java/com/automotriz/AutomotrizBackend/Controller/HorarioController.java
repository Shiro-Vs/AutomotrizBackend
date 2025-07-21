package com.automotriz.AutomotrizBackend.Controller;

import com.automotriz.AutomotrizBackend.DTO.HorarioDTO;
import com.automotriz.AutomotrizBackend.Service.HorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

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
