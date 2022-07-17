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
    private String codigoMunicipio;
    private String codigoProvincia;
    private Long ciudadanoTitularId;
    private String cedulaTitular;
    private String tipoAfiliado;
    private String tipoDependiente;
    private Long parentescoId;
    private Short seguroId;
    private Short regimenId;
    private Long institucionPensionadoId;

    public SolicitudFormDto(Short tipoIdentificacion, String cedula, String nss, String codigoMunicipio, String codigoProvincia, Long ciudadanoTitularId, String cedulaTitular, String tipoAfiliado, String tipoDependiente, Long parentescoId, Short seguroId, Short regimenId, Long institucionPensionadoId) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.cedula = cedula;
        this.nss = nss;
        this.codigoMunicipio = codigoMunicipio;
        this.codigoProvincia = codigoProvincia;
        this.ciudadanoTitularId = ciudadanoTitularId;
        this.cedulaTitular = cedulaTitular;
        this.tipoAfiliado = tipoAfiliado;
        this.tipoDependiente = tipoDependiente;
        this.parentescoId = parentescoId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.institucionPensionadoId = institucionPensionadoId;
    }

    public SolicitudFormDto() {
    }

    @Override
    public String toString() {
        return "SolicitudFormDto{" +
                "tipoIdentificacion=" + tipoIdentificacion +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", codigoMunicipio='" + codigoMunicipio + '\'' +
                ", codigoProvincia='" + codigoProvincia + '\'' +
                ", ciudadanoTitularId=" + ciudadanoTitularId +
                ", cedulaTitular='" + cedulaTitular + '\'' +
                ", tipoAfiliado='" + tipoAfiliado + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                ", parentescoId=" + parentescoId +
                ", seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", institucionPensionadoId=" + institucionPensionadoId +
                '}';
    }
}
