package com.spring.security.medi.care.app.commons.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class MotivoEstado implements Serializable {

    @Id
    private Long motivoId;
    private String descripcion;
    private String estado;

    public MotivoEstado() {
    }

    public MotivoEstado(Long motivoId) {
        this.motivoId = motivoId;
    }

    public MotivoEstado(Long motivoId, String descripcion, String estado) {
        this.motivoId = motivoId;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}
