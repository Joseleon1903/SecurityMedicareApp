package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Ciudadano implements Serializable {

    @Id
    private Long ciudadanoId;
    private String cedula;
    private Integer nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private Long municipioId;
    private Long nacionalidadId;
    private Boolean estranjero;
    private String genero;
    private Date fechaNacimiento;
    private String estado;

    public Ciudadano() {
    }

    public Ciudadano(Long ciudadanoId, String cedula, Integer nss, String nombre, String primerApellido, String segundoApellido, Long municipioId, Long nacionalidadId, Boolean estranjero, String genero, Date fechaNacimiento, String estado) {
        this.ciudadanoId = ciudadanoId;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.municipioId = municipioId;
        this.nacionalidadId = nacionalidadId;
        this.estranjero = estranjero;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }


}