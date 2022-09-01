package com.spring.security.medi.care.app.controller.dto;

import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CiudadanoFormDto {

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
    private String estado;

    public CiudadanoFormDto(Long ciudadanoId, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, Long nacionalidad, Long municipio, String genero, String fechaNacimiento, String estado) {
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
        this.estado = estado;
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
                ", estado='" + estado + '\'' +
                '}';
    }
}
