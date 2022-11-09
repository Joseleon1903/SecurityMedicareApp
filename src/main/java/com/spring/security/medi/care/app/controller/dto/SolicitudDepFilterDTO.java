package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SolicitudDepFilterDTO implements Serializable {

    private static final long serialVersionUID = 6217250970516596318L;
    private Long solicitudAfiTitular;
    private String estado;
    private String tipoDependiente;

    public SolicitudDepFilterDTO(Long solicitudAfiTitular, String estado, String tipoDependiente) {
        this.solicitudAfiTitular = solicitudAfiTitular;
        this.estado = estado;
        this.tipoDependiente = tipoDependiente;
    }

    public SolicitudDepFilterDTO() {}

    @Override
    public String toString() {
        return "SolicitudDepFilterDTO{" +
                "solicitudAfiTitular=" + solicitudAfiTitular +
                ", estado='" + estado + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                '}';
    }
}
