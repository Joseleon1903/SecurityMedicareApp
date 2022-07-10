package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class MotivoEstadoFilterDTO implements Serializable {

    private Long motivoId;
    private String descripcion;
    private int rowCounter = DaoUtil.DEFAULT_ROW_COUNT;

    public MotivoEstadoFilterDTO(Long motivoId, String descripcion) {
        this.motivoId = motivoId;
        this.descripcion = descripcion;
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

    public int getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(int rowCounter) {
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
