package com.spring.security.medi.care.app.usuario.types;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UnipagoUsuario implements Serializable {

    private Long usuarioId;
    private String codigo;
    private Long contactoId;
    private Short tipoUsuarioId;
    private String descripcionTipoUsuario;
    private String posicion;
    private String correoCorporativo;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDateTime fechaNacimiento;
    private String genero;
    private String nacionalidad;

    public UnipagoUsuario(Long usuarioId, String codigo, Long contactoId, Short tipoUsuarioId, String descripcionTipoUsuario, String posicion, String correoCorporativo, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, LocalDateTime fechaNacimiento, String genero, String nacionalidad) {
        this.usuarioId = usuarioId;
        this.codigo = codigo;
        this.contactoId = contactoId;
        this.tipoUsuarioId = tipoUsuarioId;
        this.descripcionTipoUsuario = descripcionTipoUsuario;
        this.posicion = posicion;
        this.correoCorporativo = correoCorporativo;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }

    public UnipagoUsuario() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Short getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getCorreoCorporativo() {
        return correoCorporativo;
    }

    public void setCorreoCorporativo(String correoCorporativo) {
        this.correoCorporativo = correoCorporativo;
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Long getContactoId() {
        return contactoId;
    }

    public void setContactoId(Long contactoId) {
        this.contactoId = contactoId;
    }

    @Override
    public String toString() {
        return "UnipagoUsuario{" +
                "usuarioId=" + usuarioId +
                ", codigo='" + codigo + '\'' +
                ", contactoId=" + contactoId +
                ", tipoUsuarioId=" + tipoUsuarioId +
                ", descripcionTipoUsuario='" + descripcionTipoUsuario + '\'' +
                ", posicion='" + posicion + '\'' +
                ", correoCorporativo='" + correoCorporativo + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
