package com.spring.security.medi.care.app.solicitud.dependiente.types;

import java.io.Serializable;

public class SolicitudDependiente implements Serializable {

    private long afiliacionId;
    private Long solicitudId;
    private String servicio;
    private Integer entidadId;
    private String nombreEntidad;
    private Short tipoIdentificacionId;
    private String nui;
    private Integer nss;
    private String cedula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoDependiente;
    private String tipoAfiliado;
    private String parentesco;
    private String nacionalidad;
    private String estado;
    private Integer motivoId;
    private Short seguroId;
    private Short regimenId;
    private Boolean estudiante;
    private Boolean discapacitado;
    private String cedulaTitular;
    private Long ciudadanoTitularId;
    private Long solicitudAfiliacionTitular;

    public SolicitudDependiente(long afiliacionId, Long solicitudId, String servicio, Integer entidadId, String nombreEntidad, Short tipoIdentificacionId, String nui, Integer nss, String cedula, String nombre, String primerApellido, String segundoApellido, String tipoDependiente, String tipoAfiliado, String parentesco, String naconalidad, String estado, Integer motivoId, Short seguroId, Short regimenId, Boolean estudiante, Boolean discapacitado, String cedulaTitular, Long ciudadanoTitularId, Long solicitudAfiliacionTitular) {
        this.afiliacionId = afiliacionId;
        this.solicitudId = solicitudId;
        this.servicio = servicio;
        this.entidadId = entidadId;
        this.nombreEntidad = nombreEntidad;
        this.tipoIdentificacionId = tipoIdentificacionId;
        this.nui = nui;
        this.nss = nss;
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoDependiente = tipoDependiente;
        this.tipoAfiliado = tipoAfiliado;
        this.parentesco = parentesco;
        this.nacionalidad = naconalidad;
        this.estado = estado;
        this.motivoId = motivoId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.estudiante = estudiante;
        this.discapacitado = discapacitado;
        this.cedulaTitular = cedulaTitular;
        this.ciudadanoTitularId = ciudadanoTitularId;
        this.solicitudAfiliacionTitular = solicitudAfiliacionTitular;
    }

    public SolicitudDependiente() {
    }

    public long getAfiliacionId() {
        return afiliacionId;
    }

    public void setAfiliacionId(long afiliacionId) {
        this.afiliacionId = afiliacionId;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Integer getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Integer entidadId) {
        this.entidadId = entidadId;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public Short getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(Short tipoIdentificacionId) {
        this.tipoIdentificacionId = tipoIdentificacionId;
    }

    public String getNui() {
        return nui;
    }

    public void setNui(String nui) {
        this.nui = nui;
    }

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
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

    public String getTipoDependiente() {
        return tipoDependiente;
    }

    public void setTipoDependiente(String tipoDependiente) {
        this.tipoDependiente = tipoDependiente;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public Boolean getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Boolean estudiante) {
        this.estudiante = estudiante;
    }

    public Boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public Long getCiudadanoTitularId() {
        return ciudadanoTitularId;
    }

    public void setCiudadanoTitularId(Long ciudadanoTitularId) {
        this.ciudadanoTitularId = ciudadanoTitularId;
    }

    public Long getSolicitudAfiliacionTitular() {
        return solicitudAfiliacionTitular;
    }

    public void setSolicitudAfiliacionTitular(Long solicitudAfiliacionTitular) {
        this.solicitudAfiliacionTitular = solicitudAfiliacionTitular;
    }

    @Override
    public String toString() {
        return "SolicitudDependiente{" +
                "afiliaconId=" + afiliacionId +
                ", solicitudId=" + solicitudId +
                ", servicio='" + servicio + '\'' +
                ", entidadId=" + entidadId +
                ", nombreEntidad='" + nombreEntidad + '\'' +
                ", tipoIdentificacionId=" + tipoIdentificacionId +
                ", nui='" + nui + '\'' +
                ", nss=" + nss +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                ", tipoAfiliado='" + tipoAfiliado + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", estado='" + estado + '\'' +
                ", motivoId=" + motivoId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", estudiante=" + estudiante +
                ", discapacitado=" + discapacitado +
                ", cedulaTitular='" + cedulaTitular + '\'' +
                ", ciudadanoTitularId=" + ciudadanoTitularId +
                ", solicitudAfiliacionTitular=" + solicitudAfiliacionTitular +
                '}';
    }
}





