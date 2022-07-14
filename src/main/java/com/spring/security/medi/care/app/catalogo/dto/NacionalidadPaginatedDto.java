package com.spring.security.medi.care.app.catalogo.dto;

import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import lombok.Data;

import java.util.List;

@Data
public class NacionalidadPaginatedDto {

    private List<Nacionalidad> nacionalidades;

    private PaginationOutput page;


    public NacionalidadPaginatedDto(List<Nacionalidad> nacionalidades, PaginationOutput page) {
        this.nacionalidades = nacionalidades;
        this.page = page;
    }

    public NacionalidadPaginatedDto() {
    }

    @Override
    public String toString() {
        return "NacionalidadPaginatedDto{" +
                "nacionalidades=" + nacionalidades +
                ", page=" + page +
                '}';
    }
}
