package com.spring.security.medi.care.app.commons.repository;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate fechaNacimiento;
    private String estado;

    public Ciudadano() {
    }

    public Ciudadano(Long ciudadanoId, String cedula, Integer nss, String nombre, String primerApellido, String segundoApellido, Long municipioId, Long nacionalidadId, Boolean estranjero, String genero, LocalDate fechaNacimiento, String estado) {
        this.ciudadanoId = ciudadanoId;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        municipioId = municipioId;
        this.nacionalidadId = nacionalidadId;
        this.estranjero = estranjero;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
}