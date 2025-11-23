package com.automotriz.backend.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "horarios_trabajador")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajadores trabajador;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;

    @Column(name = "dias_descanso")
    private String diasDescanso;

    // Getter y Setter para id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter y Setter para trabajador
    public Trabajadores getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajadores trabajador) {
        this.trabajador = trabajador;
    }

    // Getter y Setter para horaEntrada
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    // Getter y Setter para horaSalida
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    // Getter y Setter para diasDescanso
    public String getDiasDescanso() {
        return diasDescanso;
    }

    public void setDiasDescanso(String diasDescanso) {
        this.diasDescanso = diasDescanso;
    }
}

