package com.automotriz.AutomotrizBackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "horarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", referencedColumnName = "id_admin")
    private Trabajadores trabajador;

    private String horaEntrada;
    private String horaSalida;

    // Ejemplo: "Lunes,Martes,Miércoles,Jueves,Viernes"
    private String diasTrabajo;

    // Ejemplo: "Sábado,Domingo"
    private String diasDescanso;
}
