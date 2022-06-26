package com.spring.security.medi.care.app.commons.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class TipoEntidad implements Serializable {

    @Id
    private Long tipoEntidadId;
    private String descripcion;
    private Integer seguroId;
    private String estado;

    public TipoEntidad(Long tipoEntidadId) {
        this.tipoEntidadId = tipoEntidadId;
    }

    public TipoEntidad() {
    }

    public TipoEntidad(Long tipoEntidadId, String descripcion, Integer seguroId, String estado) {
        this.tipoEntidadId = tipoEntidadId;
        this.descripcion = descripcion;
        this.seguroId = seguroId;
        this.estado = estado;
    }
}
