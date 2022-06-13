package com.spring.wlg.solicitud.titular.domain;

import java.io.Serializable;
import java.util.Date;

public class SolicitudTitular implements Serializable {

    private Long afiliacionId;
    private Long solicitudId;
    private Integer servicioId;
    private Long loteId;
    private long numeroContrato;
    private String tipoPersona;
    private Integer entidadId;
    private Short seguroId;
    private Short regimenId;
    private Date fechaAfiliacion;
    private String tipoAfiliacion;
    private Short tipoIdentificacion;
    private String cedula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Long ciudadanoId;
    private String estado;
    private Integer motivoId;
    private String descripcionMotivo;

    public SolicitudTitular(Long afiliacionId, Long solicitudId, Integer servicioId, Long loteId,
                            long numeroContrato, String tipoPersona, Integer entidadId, Short seguroId,
                            Short regimenId, Date fechaAfiliacion, String tipoAfiliacion,
                            Short tipoIdentificacion, String cedula, String nombre, String primerApellido,
                            String segundoApellido, Long ciudadanoId, String estado, Integer motivoId, String descripcionMotivo) {
        this.afiliacionId = afiliacionId;
        this.solicitudId = solicitudId;
        this.servicioId = servicioId;
        this.loteId = loteId;
        this.numeroContrato = numeroContrato;
        this.tipoPersona = tipoPersona;
        this.entidadId = entidadId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.fechaAfiliacion = fechaAfiliacion;
        this.tipoAfiliacion = tipoAfiliacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.ciudadanoId = ciudadanoId;
        this.estado = estado;
        this.motivoId = motivoId;
        this.descripcionMotivo = descripcionMotivo;
    }

    public SolicitudTitular() {
    }

    public Long getAfiliacionId() {
        return afiliacionId;
    }

    public void setAfiliacionId(Long afiliacionId) {
        this.afiliacionId = afiliacionId;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public Long getLoteId() {
        return loteId;
    }

    public void setLoteId(Long loteId) {
        this.loteId = loteId;
    }

    public long getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(long numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Integer getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Integer entidadId) {
        this.entidadId = entidadId;
    }

    public Short getSeguroId() {
        return seguroId;
    }

    public void setSeguroId(Short seguroId) {
        this.seguroId = seguroId;
    }

    public Short getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(Short regimenId) {
        this.regimenId = regimenId;
    }

    public Date getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(Date fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(String tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public Short getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Short tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Long getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Integer motivoId) {
        this.motivoId = motivoId;
    }

    public String getDescripcionMotivo() {
        return descripcionMotivo;
    }

    public void setDescripcionMotivo(String descripcionMotivo) {
        this.descripcionMotivo = descripcionMotivo;
    }

    @Override
    public String toString() {
        return "SolicitudTitular{" +
                "afiliacionId=" + afiliacionId +
                ", solicitudId=" + solicitudId +
                ", servicioId=" + servicioId +
                ", loteId=" + loteId +
                ", numeroContrato=" + numeroContrato +
                ", tipoPersona=" + tipoPersona +
                ", entidadId=" + entidadId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", fechaAfiliacion=" + fechaAfiliacion +
                ", tipoAfiliacion='" + tipoAfiliacion + '\'' +
                ", tipoIdentificacion=" + tipoIdentificacion +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", ciudadanoId=" + ciudadanoId +
                ", estado='" + estado + '\'' +
                ", motivoId=" + motivoId +
                ", descripcionMotivo='" + descripcionMotivo + '\'' +
                '}';
    }
}