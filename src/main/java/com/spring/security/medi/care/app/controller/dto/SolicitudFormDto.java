package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Data
@Component
public class SolicitudFormDto implements Serializable {

    private Short tipoIdentificacion;
    private String cedula;
    private String nss;
    private Long municipioId;
    private String cedulaTitular;
    private String tipoAfiliado;
    private String tipoDependiente;
    private Long nacionalidadId;
    private Long seguroId;
    private Long regimenId;
    private Boolean aplicaInsitucionAutomtica;

    public SolicitudFormDto(Short tipoIdentificacion, String cedula, String nss, Long municipioId, String cedulaTitular, String tipoAfiliado, String tipoDependiente, Long nacionalidadId, Long seguroId, Long regimenId, Boolean aplicaInsitucionAutomtica) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.cedula = cedula;
        this.nss = nss;
        this.municipioId = municipioId;
        this.cedulaTitular = cedulaTitular;
        this.tipoAfiliado = tipoAfiliado;
        this.tipoDependiente = tipoDependiente;
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
                ", cedulaTitular='" + cedulaTitular + '\'' +
                ", tipoAfiliado='" + tipoAfiliado + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                ", nacionalidadId=" + nacionalidadId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", aplicaInsitucionAutomtica=" + aplicaInsitucionAutomtica +
                '}';
    }
}
