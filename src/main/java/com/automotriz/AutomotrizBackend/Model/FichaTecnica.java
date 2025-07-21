package com.automotriz.AutomotrizBackend.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ficha_tecnica")
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

    // Constructor vacío
    public FichaTecnica() {
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDiagnosticoInicial() {
        return diagnosticoInicial;
    }

    public void setDiagnosticoInicial(String diagnosticoInicial) {
        this.diagnosticoInicial = diagnosticoInicial;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }

    public LocalDate getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(LocalDate fIngreso) {
        this.fIngreso = fIngreso;
    }

    public LocalDate getFSalida() {
        return fSalida;
    }

    public void setFSalida(LocalDate fSalida) {
        this.fSalida = fSalida;
    }

    public EstadoFichaTecnica getEstado() {
        return estado;
    }

    public void setEstado(EstadoFichaTecnica estado) {
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
