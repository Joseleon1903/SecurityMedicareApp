package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class MotivoEstadoFilterDTO implements Serializable {

    private static final long serialVersionUID = 444640705128450814L;
    private Long motivoId;
    private String descripcion;
    private int rowCounter = DaoUtil.DEFAULT_ROW_COUNT;
    private int page = DaoUtil.DEFAULT_PAGE;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "MotivoEstadoFilterDTO{" +
                "motivoId=" + motivoId +
                ", descripcion='" + descripcion + '\'' +
                ", rowCounter=" + rowCounter +
                ", page=" + page +
                '}';
    }
}
