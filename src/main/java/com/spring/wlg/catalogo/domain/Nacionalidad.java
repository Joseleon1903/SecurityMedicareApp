package com.spring.wlg.catalogo.domain;

import java.io.Serializable;

public class Nacionalidad implements Serializable {

    private Long nacionalidadId;
    private String descripcion;
    private String paisId;
    private String nombrePais;
    private String estado;

    public Nacionalidad(Long nacionalidadId, String descripcion, String paisId, String nombrePais, String estado) {
        this.nacionalidadId = nacionalidadId;
        this.descripcion = descripcion;
        this.paisId = paisId;
        this.nombrePais = nombrePais;
        this.estado = estado;
    }

    public Nacionalidad() {
    }

    public Long getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Long nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nacionalidad{" +
                "nacionalidadId=" + nacionalidadId +
                ", descripcion='" + descripcion + '\'' +
                ", paisId='" + paisId + '\'' +
                ", nombrePais='" + nombrePais + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}