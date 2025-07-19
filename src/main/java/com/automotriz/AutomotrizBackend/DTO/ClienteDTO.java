package com.automotriz.AutomotrizBackend.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String dni;
    private String celular;
    private String email;
    private String direccion;
}
