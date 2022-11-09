package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Data
@Entity
public class Municipio implements Serializable {

    @Id
    @GeneratedValue
    private Long municipioId;
    private String descripcion;
    private String codigoMunicipio;
    private Integer provinciaId;
    private String estado;

    public Municipio() {
    }

    public Municipio(Long municipioId, String descripcion, String codigoMunicipio, Integer provinciaId, String estado) {
        this.municipioId = municipioId;
        this.descripcion = descripcion;
        this.codigoMunicipio = codigoMunicipio;
        this.provinciaId = provinciaId;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "municipioId=" + municipioId +
                ", descripcion='" + descripcion + '\'' +
                ", codigoMunicipio='" + codigoMunicipio + '\'' +
                ", provinciaId=" + provinciaId +
                ", estado='" + estado + '\'' +
                '}';
    }
}