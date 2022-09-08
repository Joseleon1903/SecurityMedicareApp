package com.spring.security.medi.care.app.commons.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class SolicitudAfiliacion implements Serializable {

    @Id
    @GeneratedValue
    private Long solicitudId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio_id", referencedColumnName = "servicioId")
    private ServicioSistema servicioId;
    private Integer loteId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entidad_id", referencedColumnName = "entidadId")
    private Entidad entidadId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seguro_id", referencedColumnName = "seguroId")
    private Seguro seguroId;
    private Integer regimenId;
    private String tipoAfiliado;
    private Short tipoIdentificacionId;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private Boolean automatica;
    private Long institucionPensionadoId;
    private Long claveInstitucionPensionado;
    private String estado;
    private Date fechaRecepcion;
    private Long municipioId;
    private Long ciudadanoId;
    private Long nacionalidadId;
    private Date fechaUltimoCambio;
    private Long motivoId;

    public SolicitudAfiliacion(Long solicitudId, ServicioSistema servicioId, Integer loteId, Entidad entidadId, Seguro seguroId,
            Integer regimenId, String tipoAfiliado, Short tipoIdentificacionId, String cedula, String nss,
            String nombre, String primerApellido, Boolean automatica,
            Long institucionPensionadoId, Long claveInstitucionPensionado, String estado, Date fechaRecepcion,
            Long municipioId, Long ciudadanoId, Long nacionalidadId, Date fechaUltimoCambio) {
        this.solicitudId = solicitudId;
        this.servicioId = servicioId;
        this.loteId = loteId;
        this.entidadId = entidadId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.tipoAfiliado = tipoAfiliado;
        this.tipoIdentificacionId = tipoIdentificacionId;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.automatica = automatica;
        this.institucionPensionadoId = institucionPensionadoId;
        this.claveInstitucionPensionado = claveInstitucionPensionado;
        this.estado = estado;
        this.fechaRecepcion = fechaRecepcion;
        this.municipioId = municipioId;
        this.ciudadanoId = ciudadanoId;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.nacionalidadId = nacionalidadId;
    }

    public SolicitudAfiliacion() {
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public ServicioSistema getServicioId() {
        return servicioId;
    }

    public void setServicioId(ServicioSistema servicioId) {
        this.servicioId = servicioId;
    }

    public Integer getLoteId() {
        return loteId;
    }

    public void setLoteId(Integer loteId) {
        this.loteId = loteId;
    }

    public Entidad getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Entidad entidadId) {
        this.entidadId = entidadId;
    }

    public Seguro getSeguroId() {
        return seguroId;
    }

    public void setSeguroId(Seguro seguroId) {
        this.seguroId = seguroId;
    }

    public Integer getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(Integer regimenId) {
        this.regimenId = regimenId;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public Short getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(Short tipoIdentificacionId) {
        this.tipoIdentificacionId = tipoIdentificacionId;
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

    public Boolean getAutomatica() {
        return automatica;
    }

    public void setAutomatica(Boolean automatica) {
        this.automatica = automatica;
    }

    public Long getInstitucionPensionadoId() {
        return institucionPensionadoId;
    }

    public void setInstitucionPensionadoId(Long institucionPensionadoId) {
        this.institucionPensionadoId = institucionPensionadoId;
    }

    public Long getClaveInstitucionPensionado() {
        return claveInstitucionPensionado;
    }

    public void setClaveInstitucionPensionado(Long claveInstitucionPensionado) {
        this.claveInstitucionPensionado = claveInstitucionPensionado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Long getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Long municipioId) {
        this.municipioId = municipioId;
    }

    public Long getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public Long getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Long nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public Date getFechaUltimoCambio() {
        return fechaUltimoCambio;
    }

    public void setFechaUltimoCambio(Date fechaUltimoCambio) {
        this.fechaUltimoCambio = fechaUltimoCambio;
    }

    public Long getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Long motivoId) {
        this.motivoId = motivoId;
    }

    @Override
    public String toString() {
        return "SolicitudAfiliacion{" +
                "solicitudId=" + solicitudId +
                ", servicioId=" + servicioId +
                ", loteId=" + loteId +
                ", entidadId=" + entidadId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", tipoAfiliado='" + tipoAfiliado + '\'' +
                ", tipoIdentificacionId=" + tipoIdentificacionId +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", automatica=" + automatica +
                ", institucionPensionadoId=" + institucionPensionadoId +
                ", claveInstitucionPensionado=" + claveInstitucionPensionado +
                ", estado='" + estado + '\'' +
                ", fechaRecepcion=" + fechaRecepcion +
                ", municipioId=" + municipioId +
                ", ciudadanoId=" + ciudadanoId +
                ", nacionalidadId=" + nacionalidadId +
                ", fechaUltimoCambio=" + fechaUltimoCambio +
                ", motivoId=" + motivoId +
                '}';
    }
}