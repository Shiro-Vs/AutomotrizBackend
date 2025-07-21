package com.automotriz.AutomotrizBackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class AsistenciaDTO {
    private Integer id;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private Boolean llegoTarde;
    private Boolean falto;
    private Integer idTrabajador;
}
