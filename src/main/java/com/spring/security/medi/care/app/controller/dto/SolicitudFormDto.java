package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SolicitudFormDto implements Serializable {

    private static final long serialVersionUID = -3948955345809935618L;
    private Short tipoIdentificacion;
    private String cedula;
    private String nss;
    private Long municipioId;
    private String tipoAfiliado;
    private Long nacionalidadId;
    private Long seguroId;
    private Integer regimenId;
    private Boolean aplicaInsitucionAutomtica;

    public SolicitudFormDto(Short tipoIdentificacion, String cedula, String nss, Long municipioId,
            String tipoAfiliado, Long nacionalidadId, Long seguroId, Integer regimenId,
            Boolean aplicaInsitucionAutomtica) {
        this.tipoAfiliado = tipoAfiliado;
        this.nacionalidadId = nacionalidadId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.aplicaInsitucionAutomtica = aplicaInsitucionAutomtica;
    }

    public SolicitudFormDto() {
    }

    @Override
    public String toString() {
        return "SolicitudFormDto{" +
                "tipoIdentificacion=" + tipoIdentificacion +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", municipioId='" + municipioId + '\'' +
                ", tipoAfiliado='" + tipoAfiliado + '\'' +
                ", nacionalidadId=" + nacionalidadId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", aplicaInsitucionAutomtica=" + aplicaInsitucionAutomtica +
                '}';
    }
}
