package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import org.springframework.stereotype.Component;

@Component
public class MunicipioFilterDto {

    private String codigoMunicipio;
    private String descripcion;
    private int rowCounter = DaoUtil.DEFAULT_ROW_COUNT;
    private int page = DaoUtil.DEFAULT_PAGE;

    public MunicipioFilterDto(String codigoMunicipio, String descripcion) {
        this.codigoMunicipio = codigoMunicipio;
        this.descripcion = descripcion;
    }

    public MunicipioFilterDto() {
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
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
        return "MunicipioFilterDto{" +
                "codigoMunicipio='" + codigoMunicipio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rowCounter=" + rowCounter +
                '}';
    }
}
