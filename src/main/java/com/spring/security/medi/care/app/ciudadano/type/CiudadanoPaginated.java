package com.spring.security.medi.care.app.ciudadano.type;

import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import lombok.Data;

import java.util.List;

@Data
public class CiudadanoPaginated {

    private List<Ciudadano> ciudadanos;
    private PaginationOutput pagination;

    public CiudadanoPaginated(List<Ciudadano> ciudadanos, PaginationOutput pagination) {
        this.ciudadanos = ciudadanos;
        this.pagination = pagination;
    }

    public CiudadanoPaginated() {
    }

}
