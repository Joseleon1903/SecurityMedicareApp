package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class MunicipioFilterDto implements Serializable {

    private static final long serialVersionUID = 3944801580736727929L;
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

    @Override
    public String toString() {
        return "MunicipioFilterDto{" +
                "codigoMunicipio='" + codigoMunicipio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rowCounter=" + rowCounter +
                '}';
    }
}
