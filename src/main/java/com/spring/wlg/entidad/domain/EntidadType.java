package com.spring.wlg.entidad.domain;

import java.io.Serializable;

public class EntidadType implements Serializable {

    private Integer entidadId;
    private Integer claveEntidad;
    private String sigla;
    private String descripcionEntidad;
    private String rnc;
    private Integer entidadSupervisoraId;
    private Integer tipoentidadId;
    private String descripcionTipoEntidad;
    private Short seguroId;
    private String descripcionSeguro;
    private Short regimenId;
    private String descripcionRegimen;
    private String estado;

    private String iconUrl;

    public EntidadType() {
    }

    public EntidadType(Integer entidadId, Integer claveEntidad, String sigla, String descripcionEntidad,
                       String rnc, Integer entidadSupervisoraId, Integer tipoentidadId, String descripcionTipoEntidad,
                       Short seguroId, String descripcionSeguro, Short regimenId, String descripcionRegimen, String estado) {
        this.entidadId = entidadId;
        this.claveEntidad = claveEntidad;
        this.sigla = sigla;
        this.descripcionEntidad = descripcionEntidad;
        this.rnc = rnc;
        this.entidadSupervisoraId = entidadSupervisoraId;
        this.tipoentidadId = tipoentidadId;
        this.descripcionTipoEntidad = descripcionTipoEntidad;
        this.seguroId = seguroId;
        this.descripcionSeguro = descripcionSeguro;
        this.regimenId = regimenId;
        this.descripcionRegimen = descripcionRegimen;
        this.estado = estado;
    }

    public Integer getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Integer entidadId) {
        this.entidadId = entidadId;
    }

    public Integer getClaveEntidad() {
        return claveEntidad;
    }

    public void setClaveEntidad(Integer claveEntidad) {
        this.claveEntidad = claveEntidad;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescripcionEntidad() {
        return descripcionEntidad;
    }

    public void setDescripcionEntidad(String descripcionEntidad) {
        this.descripcionEntidad = descripcionEntidad;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    public Integer getEntidadSupervisoraId() {
        return entidadSupervisoraId;
    }

    public void setEntidadSupervisoraId(Integer entidadSupervisoraId) {
        this.entidadSupervisoraId = entidadSupervisoraId;
    }

    public Integer getTipoentidadId() {
        return tipoentidadId;
    }

    public void setTipoentidadId(Integer tipoentidadId) {
        this.tipoentidadId = tipoentidadId;
    }

    public String getDescripcionTipoEntidad() {
        return descripcionTipoEntidad;
    }

    public void setDescripcionTipoEntidad(String descripcionTipoEntidad) {
        this.descripcionTipoEntidad = descripcionTipoEntidad;
    }

    public Short getSeguroId() {
        return seguroId;
    }

    public void setSeguroId(Short seguroId) {
        this.seguroId = seguroId;
    }

    public String getDescripcionSeguro() {
        return descripcionSeguro;
    }

    public void setDescripcionSeguro(String descripcionSeguro) {
        this.descripcionSeguro = descripcionSeguro;
    }

    public Short getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(Short regimenId) {
        this.regimenId = regimenId;
    }

    public String getDescripcionRegimen() {
        return descripcionRegimen;
    }

    public void setDescripcionRegimen(String descripcionRegimen) {
        this.descripcionRegimen = descripcionRegimen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "EntidadType{" +
                "entidadId=" + entidadId +
                ", claveEntidad=" + claveEntidad +
                ", sigla='" + sigla + '\'' +
                ", descripcionEntidad='" + descripcionEntidad + '\'' +
                ", rnc='" + rnc + '\'' +
                ", entidadSupervisoraId=" + entidadSupervisoraId +
                ", tipoentidadId=" + tipoentidadId +
                ", descripcionTipoEntidad='" + descripcionTipoEntidad + '\'' +
                ", seguroId=" + seguroId +
                ", descripcionSeguro='" + descripcionSeguro + '\'' +
                ", regimenId=" + regimenId +
                ", descripcionRegimen='" + descripcionRegimen + '\'' +
                ", estado='" + estado + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}