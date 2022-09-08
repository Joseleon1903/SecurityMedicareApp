package com.spring.security.medi.care.app.commons.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ServicioSistema implements Serializable {

    @Id
    @GeneratedValue
    private Long servicioId;

    private String descripcion;
    private Date fechaCreacion;
    private String estado;

    public ServicioSistema() {
    }

    public ServicioSistema(Long servicioId) {
        this.servicioId = servicioId;
    }

    public ServicioSistema(Long servicioId, String descripcion, Date fechaCreacion, String estado) {
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
