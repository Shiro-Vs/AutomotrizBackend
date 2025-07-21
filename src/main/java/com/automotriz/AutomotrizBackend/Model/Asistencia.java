package com.automotriz.AutomotrizBackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "llego_tarde")
    private Boolean llegoTarde = false;

    @Column(name = "falto")
    private Boolean falto = false;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", nullable = false)
    private Trabajadores trabajadores;

}
