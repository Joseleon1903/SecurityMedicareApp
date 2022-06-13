package com.spring.wlg.afiliacion.domain;

import java.io.Serializable;

public class SolicitudAfiliacion implements Serializable {

    private Long solicitudId;
    private Short tipoIdentificacion;
    private Long ciudadanoId;
    private String cedula;
    private String nss;
    private Short municipioId;
    private String codigoMunicipio;
    private String codigoProvincia;
    private Long ciudadanoTitularId;
    private String cedulaTitular;
    private String tipoAfiliado;
    private String tipoDependiente;
    private Long parentescoId;
    private Integer entidadId;
    private Short seguroId;
    private Short regimenId;
    private Long institucionPensionadoId;
    private String estado;
    private Integer motivoId;

    public SolicitudAfiliacion(Long solicitudId, Short tipoIdentificacion, Long ciudadanoId, String cedula, String nss, Short municipioId, String codigoMunicipio, String codigoProvincia, Long ciudadanoTitularId, String cedulaTitular, String tipoAfiliado, String tipoDependiente, Long parentescoId, Integer entidadId, Short seguroId, Short regimenId, Long institucionPensionadoId, String estado, Integer motivoId) {
        this.solicitudId = solicitudId;
        this.tipoIdentificacion = tipoIdentificacion;
        this.ciudadanoId = ciudadanoId;
        this.cedula = cedula;
        this.nss = nss;
        this.municipioId = municipioId;
        this.codigoMunicipio = codigoMunicipio;
        this.codigoProvincia = codigoProvincia;
        this.ciudadanoTitularId = ciudadanoTitularId;
        this.cedulaTitular = cedulaTitular;
        this.tipoAfiliado = tipoAfiliado;
        this.tipoDependiente = tipoDependiente;
        this.parentescoId = parentescoId;
        this.entidadId = entidadId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.institucionPensionadoId = institucionPensionadoId;
        this.estado = estado;
        this.motivoId = motivoId;
    }

    public SolicitudAfiliacion() {
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Short getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Short tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
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

    public Short getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Short municipioId) {
        this.municipioId = municipioId;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public Long getCiudadanoTitularId() {
        return ciudadanoTitularId;
    }

    public void setCiudadanoTitularId(Long ciudadanoTitularId) {
        this.ciudadanoTitularId = ciudadanoTitularId;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public String getTipoDependiente() {
        return tipoDependiente;
    }

    public void setTipoDependiente(String tipoDependiente) {
        this.tipoDependiente = tipoDependiente;
    }

    public Long getParentescoId() {
        return parentescoId;
    }

    public void setParentescoId(Long parentescoId) {
        this.parentescoId = parentescoId;
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

    public Long getInstitucionPensionadoId() {
        return institucionPensionadoId;
    }

    public void setInstitucionPensionadoId(Long institucionPensionadoId) {
        this.institucionPensionadoId = institucionPensionadoId;
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

    @Override
    public String toString() {
        return "SolicitudAfiliacion{" +
                "solicitudId=" + solicitudId +
                ", tipoIdentificacion=" + tipoIdentificacion +
                ", ciudadanoId=" + ciudadanoId +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", municipioId='" + municipioId + '\'' +
                ", codigoMunicipio='" + codigoMunicipio + '\'' +
                ", codigoProvincia='" + codigoProvincia + '\'' +
                ", ciudadanoTitularId=" + ciudadanoTitularId +
                ", cedulaTitular='" + cedulaTitular + '\'' +
                ", tipoAfiliado='" + tipoAfiliado + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                ", parentescoId=" + parentescoId +
                ", entidadId=" + entidadId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", institucionPensionadoId=" + institucionPensionadoId +
                ", estado='" + estado + '\'' +
                ", motivoId=" + motivoId +
                '}';
    }
}
