package com.automotriz.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

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

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalTime horaEntrada) { this.horaEntrada = horaEntrada; }

    public Boolean getLlegoTarde() { return llegoTarde; }
    public void setLlegoTarde(Boolean llegoTarde) { this.llegoTarde = llegoTarde; }

    public Boolean getFalto() { return falto; }
    public void setFalto(Boolean falto) { this.falto = falto; }

    public Trabajadores getTrabajadores() { return trabajadores; }
    public void setTrabajadores(Trabajadores trabajadores) { this.trabajadores = trabajadores; }
}



