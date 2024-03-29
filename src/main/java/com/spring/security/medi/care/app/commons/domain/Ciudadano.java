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
public class Ciudadano implements Serializable {

    @Id
    @GeneratedValue
    private Long ciudadanoId;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private Long municipioId;
    private Long nacionalidadId;
    private String genero;
    private LocalDate fechaNacimiento;
    private String estado;

    public Ciudadano(){}

    public Ciudadano(Long ciudadanoId, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, Long municipioId, Long nacionalidadId, String genero, LocalDate fechaNacimiento, String estado) {
        this.ciudadanoId = ciudadanoId;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.municipioId = municipioId;
        this.nacionalidadId = nacionalidadId;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Ciudadano(String cedula, String nss, String nombre, String primerApellido, String segundoApellido, Long municipioId, Long nacionalidadId,  String genero, LocalDate fechaNacimiento, String estado) {
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.municipioId = municipioId;
        this.nacionalidadId = nacionalidadId;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "ciudadanoId=" + ciudadanoId +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", municipioId=" + municipioId +
                ", nacionalidadId=" + nacionalidadId +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", estado='" + estado + '\'' +
                '}';
    }
}