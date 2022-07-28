package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DetalleSolicitudAfiliacionDto {

    private Long solicitudId;
    private String entidadNombre;
    private String tipoAfiliado;
    private String tipoDependiente;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String institucionPensionado;
    private String estado;
    private String motivo;

    public DetalleSolicitudAfiliacionDto(){
    }

    public DetalleSolicitudAfiliacionDto(SolicitudAfiliacion solicitudAfiliacion){
    }

    public DetalleSolicitudAfiliacionDto(SolicitudAfiliacion solicitudAfiliacion, String entidadNombre, String segundoApellido, String institucionPensionado, String motivo) {
        this.solicitudId = solicitudAfiliacion.getSolicitudId();
        this.entidadNombre = entidadNombre;
        this.tipoAfiliado = solicitudAfiliacion.getTipoAfiliado();
        this.tipoDependiente = solicitudAfiliacion.getTipoDependiente();
        this.cedula = solicitudAfiliacion.getCedula();
        this.nss = solicitudAfiliacion.getNss();
        this.nombre = solicitudAfiliacion.getNombre();
        this.primerApellido = solicitudAfiliacion.getPrimerApellido();
        this.segundoApellido = solicitudAfiliacion.getSegundoApellido();
        this.institucionPensionado = institucionPensionado;
        this.estado = solicitudAfiliacion.getEstado();
        this.motivo = motivo;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getEntidadNombre() {
        return entidadNombre;
    }

    public void setEntidadNombre(String entidadNombre) {
        this.entidadNombre = entidadNombre;
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

    public String getInstitucionPensionado() {
        return institucionPensionado;
    }

    public void setInstitucionPensionado(String institucionPensionado) {
        this.institucionPensionado = institucionPensionado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
