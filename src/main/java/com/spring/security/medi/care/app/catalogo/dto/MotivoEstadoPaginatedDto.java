package com.spring.security.medi.care.app.catalogo.dto;

import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import lombok.Data;

import java.util.List;

@Data
public class MotivoEstadoPaginatedDto {

    private List<MotivoEstado> motivos;

    private PaginationOutput page;

    public MotivoEstadoPaginatedDto() {
    }

    public MotivoEstadoPaginatedDto(List<MotivoEstado> motivos, PaginationOutput page) {
        this.motivos = motivos;
        this.page = page;
    }

    @Override
    public String toString() {
        return "MotivoEstadoPaginatedDto{" +
                "motivos=" + motivos +
                ", page=" + page +
                '}';
    }
}