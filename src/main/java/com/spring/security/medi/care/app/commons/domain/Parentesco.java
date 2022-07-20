package com.spring.security.medi.care.app.commons.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Parentesco implements Serializable {

    @Id
    private Long parentescoId;
    private String descripcion;
    private String tipoDependiente;
    private String genero;
    private Long gradoConsanguinidadId;
    private String estado;

    public Parentesco() {
    }

    public Parentesco(Long parentescoId, String descripcion, String tipoDependiente, String genero, Long gradoConsanguinidadId, String estado) {
        this.parentescoId = parentescoId;
        this.descripcion = descripcion;
        this.tipoDependiente = tipoDependiente;
        this.genero = genero;
        this.gradoConsanguinidadId = gradoConsanguinidadId;
        this.estado = estado;
    }
}
