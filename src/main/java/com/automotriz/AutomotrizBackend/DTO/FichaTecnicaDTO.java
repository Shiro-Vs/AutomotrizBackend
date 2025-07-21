package com.automotriz.AutomotrizBackend.DTO;

import com.automotriz.AutomotrizBackend.Model.EstadoFichaTecnica;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class FichaTecnicaDTO {
    private Integer id;
    private String observaciones;
    private String diagnosticoInicial;
    private String servicios;
    private String repuestos;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fIngreso;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fSalida;

    private EstadoFichaTecnica estado;
    private Integer idVehiculo; // Solo el ID del vehículo, no el objeto completo
    private String placaVehiculo; // Placa del vehículo para mostrar en la ficha técnica
    private String marcaVehiculo; // Marca del vehículo para mostrar en la ficha técnica
    private String colorVehiculo; // Modelo del vehículo para mostrar en la ficha técnica

    private String nombreCliente;

}
