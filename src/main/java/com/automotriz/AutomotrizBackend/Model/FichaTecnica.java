package com.automotriz.AutomotrizBackend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ficha_tecnica")
@NoArgsConstructor
@Data
public class FichaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "diagnostico_inicial", columnDefinition = "TEXT")
    private String diagnosticoInicial;

    @Column(columnDefinition = "TEXT")
    private String servicios;

    @Column(columnDefinition = "TEXT")
    private String repuestos;

    private LocalDate fIngreso;
    private LocalDate fSalida;

    @Enumerated(EnumType.STRING)
    private EstadoFichaTecnica estado;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
}

