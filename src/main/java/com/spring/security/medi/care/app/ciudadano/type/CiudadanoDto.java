package com.spring.security.medi.care.app.ciudadano.type;

import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class CiudadanoDto implements Serializable {

    private Long ciudadanoId;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private String nacionalidad;
    private String municipio;

    private String genero;
    private LocalDate fechaNacimiento;
    private String estado;

    public CiudadanoDto(Long ciudadanoId, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, String nacionalidad,String municipio, String genero, LocalDate fechaNacimiento, String estado) {
        this.ciudadanoId = ciudadanoId;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.municipio =municipio;
        this.estado = estado;
    }

    public CiudadanoDto(Ciudadano ciudadano, String nacionalidad, String municipio) {
        this.ciudadanoId = ciudadano.getCiudadanoId();
        this.cedula = ciudadano.getCedula();
        this.nss = ciudadano.getNss();
        this.nombre = ciudadano.getNombre();
        this.primerApellido = ciudadano.getPrimerApellido();
        this.segundoApellido = ciudadano.getSegundoApellido();
        this.nacionalidad = nacionalidad;
        this.genero = ciudadano.getGenero();
        this.fechaNacimiento = ciudadano.getFechaNacimiento();
        this.estado = ciudadano.getEstado();
        this.municipio = municipio;
    }

    public CiudadanoDto() {
    }

    @Override
    public String toString() {
        return "CiudadanoDto{" +
                "ciudadanoId=" + ciudadanoId +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", nacionalidadId='" + nacionalidad + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", estado='" + estado + '\'' +
                '}';
    }
}
