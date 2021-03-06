package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class InstitucionPensionado implements Serializable {

    @Id
    private Long institucionPensionadoId;
    private String descripcion;
    private String estado;

    public InstitucionPensionado(Long institucionPensionadoId, String descripcion, String estado) {
        this.institucionPensionadoId = institucionPensionadoId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public InstitucionPensionado() {
    }


}