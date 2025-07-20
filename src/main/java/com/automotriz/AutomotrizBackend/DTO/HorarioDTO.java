package com.automotriz.AutomotrizBackend.DTO;

import lombok.Data;

@Data
public class HorarioDTO {
    private Integer id;
    private Integer idTrabajador;
    private String horaEntrada;
    private String horaSalida;
    private String diasTrabajo;
    private String diasDescanso;
}
