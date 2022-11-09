package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimoCambio;
    private String estado;

    public Contacto() {
    }

    public Contacto(Long contactoId) {
        this.contactoId = contactoId;
    }

    public Contacto(Long contactoId, String descripcion, String correoPrimario, String correoAlterno, String posicion, LocalDateTime fechaCreacion, LocalDateTime fechaUltimoCambio, String estado) {
        this.contactoId = contactoId;
        this.descripcion = descripcion;
        this.correoPrimario = correoPrimario;
        this.correoAlterno = correoAlterno;
        this.posicion = posicion;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "contactoId=" + contactoId +
                ", descripcion='" + descripcion + '\'' +
                ", correoPrimario='" + correoPrimario + '\'' +
                ", correoAlterno='" + correoAlterno + '\'' +
                ", posicion='" + posicion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaUltimoCambio=" + fechaUltimoCambio +
                ", estado='" + estado + '\'' +
                '}';
    }
}