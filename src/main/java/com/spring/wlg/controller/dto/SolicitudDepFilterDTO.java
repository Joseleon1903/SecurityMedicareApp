package com.spring.wlg.controller.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class SolicitudDepFilterDTO implements Serializable {

    private Long solicitudAfiTitular;
    private String estado;
    private String tipoDependiente;

    public SolicitudDepFilterDTO(Long solicitudAfiTitular, String estado, String tipoDependiente) {
        this.solicitudAfiTitular = solicitudAfiTitular;
        this.estado = estado;
        this.tipoDependiente = tipoDependiente;
    }

    public SolicitudDepFilterDTO() {}

    public Long getSolicitudAfiTitular() {
        return solicitudAfiTitular;
    }

    public void setSolicitudAfiTitular(Long solicitudAfiTitular) {
        this.solicitudAfiTitular = solicitudAfiTitular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDependiente() {
        return tipoDependiente;
    }

    public void setTipoDependiente(String tipoDependiente) {
        this.tipoDependiente = tipoDependiente;
    }

    @Override
    public String toString() {
        return "SolicitudDepFilterDTO{" +
                "solicitudAfiTitular=" + solicitudAfiTitular +
                ", estado='" + estado + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                '}';
    }
}
