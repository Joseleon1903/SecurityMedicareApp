package com.spring.wlg.controller.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NacionalidadFilterDTO implements Serializable {

    private String paisId;
    private String nombre;
    private String rowCounter;

    public NacionalidadFilterDTO(String paisId, String nombre) {
        this.paisId = paisId;
        this.nombre = nombre;
    }

    public NacionalidadFilterDTO(String paisId, String nombre, String rowCounter) {
        this.paisId = paisId;
        this.nombre = nombre;
        this.rowCounter = rowCounter;
    }

    public NacionalidadFilterDTO() {}

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(String rowCounter) {
        this.rowCounter = rowCounter;
    }

    @Override
    public String toString() {
        return "NacionalidadFilterDTO{" +
                "paisId='" + paisId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rowCounter=" + rowCounter +
                '}';
    }
}
