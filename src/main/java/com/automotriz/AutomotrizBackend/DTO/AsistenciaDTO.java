package com.automotriz.AutomotrizBackend.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AsistenciaDTO {
    private Integer id;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private Boolean llegoTarde;
    private Boolean falto;
    private Integer idTrabajador;

    // Getter y Setter para id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter y Setter para fecha
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para horaEntrada
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    // Getter y Setter para llegoTarde
    public Boolean getLlegoTarde() {
        return llegoTarde;
    }
    public void setLlegoTarde(Boolean llegoTarde) {
        this.llegoTarde = llegoTarde;
    }

    // Getter y Setter para falto
    public Boolean getFalto() {
        return falto;
    }
    public void setFalto(Boolean falto) {
        this.falto = falto;
    }

    // Getter y Setter para idTrabajador
    public Integer getIdTrabajador() {
        return idTrabajador;
    }
    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
}
