package com.spring.security.medi.care.app.catalogo.dto;

import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.Municipio;
import lombok.Data;

import java.util.List;

@Data
public class MunicipioPaginatedDto {

    private List<Municipio> municipios;

    private PaginationOutput page;

    public MunicipioPaginatedDto(List<Municipio> municipios, PaginationOutput page) {
        this.municipios = municipios;
        this.page = page;
    }

    public MunicipioPaginatedDto() {
    }

    @Override
    public String toString() {
        return "MunicipioPaginatedDto{" +
                "municipios=" + municipios +
                ", page=" + page +
                '}';
    }
}
