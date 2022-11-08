package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.AfiliacionDtoUtil;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
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
