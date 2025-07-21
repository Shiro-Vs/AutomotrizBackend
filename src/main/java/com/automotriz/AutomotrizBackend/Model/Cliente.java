package com.automotriz.AutomotrizBackend.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String dni;
    private String celular;
    private String email;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Trabajadores trabajadores;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;

    // Constructor vacío
    public Cliente() {}

    // Constructor con todos los campos
    public Cliente(Integer id, String nombre, String dni, String celular, String email, String direccion,
                   Trabajadores trabajadores, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
        this.trabajadores = trabajadores;
        this.vehiculos = vehiculos;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

