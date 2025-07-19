package com.automotriz.AutomotrizBackend.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trabajadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trabajadores {

    @OneToMany(mappedBy = "trabajadores")
    private List<Cliente> clientes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_admin;

    private String nombre;
    private String dni;
    private String celular;
    private String email;
    private String direccion;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private String contrasenia;
    private Boolean estado;

    private String rol;
}
