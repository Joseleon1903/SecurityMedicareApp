package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Nacionalidad implements Serializable {

    @Id
    private Long nacionalidadId;
    private String descripcion;
    private String paisId;
    private String estado;

    public Nacionalidad() {
    }

    public Nacionalidad(Long nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public Nacionalidad(Long nacionalidadId, String descripcion, String paisId, String estado) {
        this.nacionalidadId = nacionalidadId;
        this.descripcion = descripcion;
        this.paisId = paisId;
        this.estado = estado;
    }
}
