package com.spring.security.medi.care.app.controller.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class TitularFilterDTO implements Serializable {

    private static final long serialVersionUID = -5213039614102084959L;
    private String ciudadanoId;
    private String entidadId;
    private String numeroContrato;
    private String tipoPersona;
    private String estado;

    public TitularFilterDTO(String ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public TitularFilterDTO() {}

    public String getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(String ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(String entidadId) {
        this.entidadId = entidadId;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TitularFilterDTO{" +
                "ciudadanoId='" + ciudadanoId + '\'' +
                ", entidadId='" + entidadId + '\'' +
                ", numeroContrato='" + numeroContrato + '\'' +
                ", tipoPersona='" + tipoPersona + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
