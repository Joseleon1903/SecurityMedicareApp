package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class CiudadanoFormDto implements Serializable {

    private static final long serialVersionUID = -5010754159267247701L;

    private Long ciudadanoId;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private Long nacionalidad;
    private Long municipio;

    private String genero;
    private String fechaNacimiento;

    public CiudadanoFormDto(Long ciudadanoId, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, Long nacionalidad, Long municipio, String genero, String fechaNacimiento) {
        this.ciudadanoId = ciudadanoId;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nacionalidad = nacionalidad;
        this.municipio = municipio;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public CiudadanoFormDto() {
    }


    @Override
    public String toString() {
        return "CiudadanoFormDto{" +
                "ciudadanoId=" + ciudadanoId +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", municipio='" + municipio + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
