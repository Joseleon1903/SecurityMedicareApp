package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class ServicioSistema implements Serializable {

    @Id
    @GeneratedValue
    private Long servicioId;

    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;

    public ServicioSistema() {
    }

    public ServicioSistema(Long servicioId) {
        this.servicioId = servicioId;
    }

    public ServicioSistema(Long servicioId, String descripcion, LocalDate fechaCreacion, String estado) {
        this.servicioId = servicioId;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ServicioSistema{" +
                "servicioId=" + servicioId +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
