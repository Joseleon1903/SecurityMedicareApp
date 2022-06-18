package com.spring.security.medi.care.app.catalogo.domain;

import java.io.Serializable;

public class MotivoEstado implements Serializable {

    private long motivoId;
    private String descripcion;
    private String estado;

    public MotivoEstado(long motivoId, String descripcion, String estado) {
        this.motivoId = motivoId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public MotivoEstado() {}

    public long getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(long motivoId) {
        this.motivoId = motivoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MotivoEstado{" +
                "motivoId=" + motivoId +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
