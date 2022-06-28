package com.spring.security.medi.care.app.commons.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class TipoUsuario implements Serializable {

    @Id
    private Long tipoUsuarioId;
    private String descripcion;
    private Integer tipo_persona;
    private String estado;

    public TipoUsuario() {
    }

    public TipoUsuario(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public TipoUsuario(Long tipoUsuarioId, String descripcion, Integer tipo_persona, String estado) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.descripcion = descripcion;
        this.tipo_persona = tipo_persona;
        this.estado = estado;
    }
}