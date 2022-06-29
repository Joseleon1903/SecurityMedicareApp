package com.spring.security.medi.care.app.commons.repository;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Parentesco implements Serializable {

    @Id
    private Long parentescoId;
    private String descripcionParentesco;
    private String tipoDependiente;
    private String genero;
    private Long gradoConsanguinidadId;
    private String estado;

    public Parentesco() {
    }

    public Parentesco(Long parentescoId, String descripcionParentesco, String tipoDependiente, String genero, Long gradoConsanguinidadId, String estado) {
        this.parentescoId = parentescoId;
        this.descripcionParentesco = descripcionParentesco;
        this.tipoDependiente = tipoDependiente;
        this.genero = genero;
        this.gradoConsanguinidadId = gradoConsanguinidadId;
        this.estado = estado;
    }
}
