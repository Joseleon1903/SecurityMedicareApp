package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@Entity
public class Contacto implements Serializable {

    @Id
    private Long contactoId;
    private Integer tipoPersona;
    private Long entidadId;
    private Long ciudadanoId;
    private String descripcion;
    private String correoCoorporativo;
    private String correoAlterno;
    private String posicion;
    private LocalDate fechaCreacion;
    private LocalDate fechaUltimoCambio;
    private Boolean tieneHijos;
    private String estado;

    public Contacto() {
    }

    public Contacto(Long contactoId, Integer tipoPersona, Long entidadId, Long ciudadanoId, String descripcion, String correoCoorporativo, String correoAlterno, String posicion, LocalDate fechaCreacion, LocalDate fechaUltimoCambio, Boolean tieneHijos, String estado) {
        this.contactoId = contactoId;
        this.tipoPersona = tipoPersona;
        this.entidadId = entidadId;
        this.ciudadanoId = ciudadanoId;
        this.descripcion = descripcion;
        this.correoCoorporativo = correoCoorporativo;
        this.correoAlterno = correoAlterno;
        this.posicion = posicion;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.tieneHijos = tieneHijos;
        this.estado = estado;
    }

}
