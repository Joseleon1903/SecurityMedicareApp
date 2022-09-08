package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Contacto implements Serializable {

    @Id
    @GeneratedValue
    private Long contactoId;

    private String descripcion;
    private String correoPrimario;
    private String correoAlterno;
    private String posicion;
    private LocalDate fechaCreacion;
    private LocalDate fechaUltimoCambio;
    private String estado;

    public Contacto() {
    }

    public Contacto(Long contactoId) {
        this.contactoId = contactoId;
    }

    public Contacto(Long contactoId, String descripcion, String correoPrimario, String correoAlterno, String posicion, LocalDate fechaCreacion, LocalDate fechaUltimoCambio, String estado) {
        this.contactoId = contactoId;
        this.descripcion = descripcion;
        this.correoPrimario = correoPrimario;
        this.correoAlterno = correoAlterno;
        this.posicion = posicion;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }

}