package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Seguro implements Serializable {

    @Id
    @GeneratedValue
    private Long seguroId;
    private String descripcion;
    private String estado;

    public Seguro() {
    }

    public Seguro(Long seguroId, String descripcion, String estado) {
        this.seguroId = seguroId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Seguro(Long seguroId) {
        this.seguroId = seguroId;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "seguroId=" + seguroId +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
