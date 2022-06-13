package com.spring.wlg.controller.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class MotivoEstadoFilterDTO implements Serializable {

    private Long motivoId;
    private String descripcion;
    private String rowCounter;

    public MotivoEstadoFilterDTO(Long motivoId, String descripcion) {
        this.motivoId = motivoId;
        this.descripcion = descripcion;
    }

    public MotivoEstadoFilterDTO(Long motivoId, String descripcion, String rowCounter) {
        this.motivoId = motivoId;
        this.descripcion = descripcion;
        this.rowCounter = rowCounter;
    }

    public MotivoEstadoFilterDTO() {}

    public Long getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Long motivoId) {
        this.motivoId = motivoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(String rowCounter) {
        this.rowCounter = rowCounter;
    }

    @Override
    public String toString() {
        return "MotivoEstadoFilterDTO{" +
                "motivoId=" + motivoId +
                ", descripcion='" + descripcion + '\'' +
                ", rowCounter='" + rowCounter + '\'' +
                '}';
    }
}
