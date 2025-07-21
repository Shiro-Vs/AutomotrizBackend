package com.automotriz.AutomotrizBackend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "horarios_trabajador")
@Data
@Getter
@Setter
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajadores trabajador;

    @Column(name = "hora_entrada", nullable = false)
    private java.time.LocalTime horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private java.time.LocalTime horaSalida;

    @Column(name = "dias_descanso")
    private String diasDescanso; // Ejemplo: "Sábado,Domingo"
}
