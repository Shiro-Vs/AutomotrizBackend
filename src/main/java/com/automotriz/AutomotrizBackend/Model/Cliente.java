package com.automotriz.AutomotrizBackend.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String dni;
    private String celular;
    private String email;
    private String direccion;

    // Relación con Administrador (opcional)
    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Trabajadores trabajadores;

    // Relación con Vehiculos
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;
}
