package com.spring.security.medi.care.app.commons.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Usuario implements Serializable {

    private Long usuarioId;
    private String codigo;
    private Long contactoId;
    private Long tipousuarioId;
    private String llaveEncriptacion;
    private LocalDate fechaUltimoCambio;
    private String estado;


    public Usuario() {
    }

    public Usuario(Long usuarioId, String codigo, Long contactoId, Long tipousuarioId, String llaveEncriptacion, LocalDate fechaUltimoCambio, String estado) {
        this.usuarioId = usuarioId;
        this.codigo = codigo;
        this.contactoId = contactoId;
        this.tipousuarioId = tipousuarioId;
        this.llaveEncriptacion = llaveEncriptacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }
}
