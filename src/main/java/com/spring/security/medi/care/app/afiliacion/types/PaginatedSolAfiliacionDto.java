package com.spring.security.medi.care.app.afiliacion.types;

import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class PaginatedSolAfiliacionDto implements Serializable {

    private List<SolicitudAfiliacion> solicitudes;
    private PaginationOutput pagination;

    public PaginatedSolAfiliacionDto(List<SolicitudAfiliacion> solicitudes, PaginationOutput pagination) {
        this.solicitudes = solicitudes;
        this.pagination = pagination;
    }

    public PaginatedSolAfiliacionDto() {
    }

    @Override
    public String toString() {
        return "PaginatedSolAfiliacionDto{" +
                "solicitudes=" + solicitudes +
                ", pagination=" + pagination +
                '}';
    }
}
