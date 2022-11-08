package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
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
