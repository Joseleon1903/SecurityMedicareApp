package com.spring.security.medi.care.app.ciudadano.type;

import com.spring.security.medi.care.app.commons.domain.Ciudadano;

import java.io.Serializable;
import java.util.Date;

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
    private Date fechaNacimiento;
    private String estado;

    public CiudadanoDto(Long ciudadanoId, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, String nacionalidad,String municipio, String genero, Date fechaNacimiento, String estado) {
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

    public Long getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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
