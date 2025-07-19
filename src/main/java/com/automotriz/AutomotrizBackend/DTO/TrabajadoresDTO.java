package com.automotriz.AutomotrizBackend.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TrabajadoresDTO {
    private Integer id;
    private String nombre;
    private String dni;
    private String celular;
    private String email;
    private String direccion;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private Boolean estado;
    private String rol;
    private String contrasenia;
}
