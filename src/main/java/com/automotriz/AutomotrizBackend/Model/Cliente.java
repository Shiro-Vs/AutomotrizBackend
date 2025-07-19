package com.automotriz.AutomotrizBackend.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
