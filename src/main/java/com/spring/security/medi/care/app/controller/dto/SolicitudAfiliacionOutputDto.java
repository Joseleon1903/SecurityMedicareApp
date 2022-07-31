package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.AfiliacionDtoUtil;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@Component
public class SolicitudAfiliacionOutputDto implements Serializable{

    private Long solicitudId;
    private Integer servicioId;
    private Integer loteId;
    private String seguroId;
    private String regimenId;
    private String tipoAfiliado;
    private String cedula;
    private String nss;
    private String cedulaTitular;
    private Long entidadId;
    private Boolean automatica;
    private String estado;
    private Date fechaRecepcion;
    private Long municipioId;
    private Long motivoId;

    public SolicitudAfiliacionOutputDto(Long solicitudId, Integer servicioId, Integer loteId, String seguroId, String regimenId, String tipoAfiliado, String cedula, String nss, String cedulaTitular, Long entidadId, Boolean automatica, String estado, Date fechaRecepcion, Long municipioId) {
        this.solicitudId = solicitudId;
        this.servicioId = servicioId;
        this.loteId = loteId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.tipoAfiliado = tipoAfiliado;
        this.cedula = cedula;
        this.nss = nss;
        this.cedulaTitular = cedulaTitular;
        this.entidadId = entidadId;
        this.automatica = automatica;
        this.estado = estado;
        this.fechaRecepcion = fechaRecepcion;
        this.municipioId = municipioId;
    }

    public SolicitudAfiliacionOutputDto() {
    }

    public SolicitudAfiliacionOutputDto(SolicitudAfiliacion solicitud) {
        this.solicitudId = solicitud.getSolicitudId();
        this.servicioId = solicitud.getServicioId();
        this.loteId = solicitud.getLoteId();
        this.seguroId = AfiliacionDtoUtil.convertSeguroId(solicitud.getSeguroId());
        this.regimenId =AfiliacionDtoUtil.convertRegimenId(solicitud.getRegimenId()) ;
        this.tipoAfiliado =AfiliacionDtoUtil.convertTipoAfiliado(solicitud.getTipoAfiliado());
        this.cedula = solicitud.getCedula();
        this.nss = solicitud.getNss();
        this.cedulaTitular = solicitud.getCedulaTitular();
        this.entidadId = solicitud.getEntidadId();
        this.automatica = solicitud.getAutomatica();
        this.estado =AfiliacionDtoUtil.convertEstado(solicitud.getEstado());
        this.fechaRecepcion = solicitud.getFechaRecepcion();
        this.municipioId = solicitud.getMunicipioId();
    }



}
