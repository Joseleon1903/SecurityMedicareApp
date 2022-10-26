package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.AfiliacionDtoUtil;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DetalleSolicitudAfiliacionDto implements Serializable {

    private static final long serialVersionUID = 6130293591590128900L;
    private Long solicitudId;
    private String entidadNombre;
    private String tipoAfiliado;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String institucionPensionado;
    private String estado;
    private String motivo;

    private String descripcionEstado;

    public DetalleSolicitudAfiliacionDto(){
    }

    public DetalleSolicitudAfiliacionDto(SolicitudAfiliacion solicitudAfiliacion, String entidadNombre, String segundoApellido, String institucionPensionado, String motivo) {
        this.solicitudId = solicitudAfiliacion.getSolicitudId();
        this.entidadNombre = entidadNombre;
        this.tipoAfiliado = solicitudAfiliacion.getTipoAfiliado();
        this.cedula = solicitudAfiliacion.getCedula();
        this.nss = solicitudAfiliacion.getNss();
        this.nombre = solicitudAfiliacion.getNombre();
        this.primerApellido = solicitudAfiliacion.getPrimerApellido();
        this.segundoApellido = segundoApellido;
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

    public String getDescripcionEstado() {

        if(AfiliacionDtoUtil.C_ESTADO_PE.equals(this.estado)){
            return "Solicitud en estado pendiente de procesar datos incompletos.";
        }

        if(AfiliacionDtoUtil.C_ESTADO_RE.equals(this.estado)){
            return "Solicitud en estado rechazada validad motivo de rechazo y volver a enviar la soliciud.";
        }

        if(AfiliacionDtoUtil.C_ESTADO_OK.equals(this.estado)){
            return "Solicitud en estado aceptada.";
        }


        return descripcionEstado;
    }
}
