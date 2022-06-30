package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class GradoConsanguinidad implements Serializable {

    @Id
    private Long gradoConsanguinidadId;
    private String descripcion;

    public GradoConsanguinidad() {}

    public GradoConsanguinidad(Long gradoConsanguinidadId, String descripcion) {
        this.gradoConsanguinidadId = gradoConsanguinidadId;
        this.descripcion = descripcion;
    }
}
