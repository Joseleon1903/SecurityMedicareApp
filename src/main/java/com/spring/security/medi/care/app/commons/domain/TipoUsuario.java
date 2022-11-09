package com.spring.security.medi.care.app.commons.domain;

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
    private String estado;

    public TipoUsuario() {
    }

    public TipoUsuario(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public TipoUsuario(Long tipoUsuarioId, String descripcion, String estado) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "tipoUsuarioId=" + tipoUsuarioId +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}