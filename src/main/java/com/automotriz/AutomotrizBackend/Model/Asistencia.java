package com.automotriz.AutomotrizBackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", referencedColumnName = "id_admin")
    private Trabajadores trabajadores;

    private LocalDate fecha;

    private LocalTime horaEntrada;  // ✅ agregar
    private LocalTime horaSalida;   // ✅ agregar

    private String estado;
}

