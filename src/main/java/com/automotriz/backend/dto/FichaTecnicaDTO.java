package com.automotriz.backend.dto;

import com.automotriz.backend.model.EstadoFichaTecnica;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FichaTecnicaDTO {
    private Integer id;
    private String observaciones;
    private String diagnosticoInicial;
    private String servicios;
    private String repuestos;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fIngreso;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fSalida;

    private EstadoFichaTecnica estado;
    private Integer idVehiculo;
    private String placaVehiculo;
    private String marcaVehiculo;
    private String colorVehiculo;

    private String nombreCliente;

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

    public Integer getIdVehiculo() {
        return idVehiculo;
    }
    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }
    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }
    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }
    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}

