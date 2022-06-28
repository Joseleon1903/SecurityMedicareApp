package com.spring.security.medi.care.app.commons.repository;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SolicitudAfiliacion implements Serializable {


    private Long solicitudId;
    private Integer servivioId;
    private Integer loteId;
    private Long entidadId;
    private Long seguroId;
    private Long regimenId;
    private String tipoAfiliado;
    private Short tipoIdentificacionId;
    private String nombre;
    private String primerApellido;
    private Boolean automatica;
    private Long institucionPensionadoId;
    private Long claveInstitucionPensionado;
    private String estado;
    private LocalDate fechaRecepcion;
    private Long municipioId;
    private Long ciudadanoId;
    private LocalDate fechaUltimoCambio;

    public SolicitudAfiliacion(Long solicitudId, Integer servivioId, Integer loteId, Long entidadId, Long seguroId, Long regimenId, String tipoAfiliado, Short tipoIdentificacionId, String nombre, String primerApellido, Boolean automatica, Long institucionPensionadoId, Long claveInstitucionPensionado, String estado, LocalDate fechaRecepcion, Long municipioId, Long ciudadanoId, LocalDate fechaUltimoCambio) {
        this.solicitudId = solicitudId;
        this.servivioId = servivioId;
        this.loteId = loteId;
        this.entidadId = entidadId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.tipoAfiliado = tipoAfiliado;
        this.tipoIdentificacionId = tipoIdentificacionId;
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
    }

    public SolicitudAfiliacion() {
    }

}