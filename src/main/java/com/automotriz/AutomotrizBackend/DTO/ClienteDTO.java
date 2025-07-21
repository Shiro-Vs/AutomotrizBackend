package com.automotriz.AutomotrizBackend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String dni;
    private String celular;
    private String email;
    private String direccion;
}
