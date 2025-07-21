package com.automotriz.AutomotrizBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehiculo")
@NoArgsConstructor
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("vehiculos")
    private Cliente cliente;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FichaTecnica> fichasTecnicas;

    public Vehiculo(String placa, String marca, String modelo, Integer anio, String color, LocalDate fechaRegistro,
            Cliente cliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.fechaRegistro = fechaRegistro;
        this.cliente = cliente;
    }
}
