package com.automotriz.AutomotrizBackend.DTO;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class VehiculoDTO {
    private Integer id;
    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private LocalDate fechaRegistro;
    private Integer idCliente;
    private String nombreCliente;
}
