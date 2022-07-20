package com.spring.security.medi.care.app.commons.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class SolicitudAfiliacion implements Serializable {

    @Id
    @GeneratedValue
    private Long solicitudId;
    private Integer servicioId;
    private Integer loteId;
    private Long entidadId;
    private Long seguroId;
    private Long regimenId;
    private String tipoAfiliado;
    private Short tipoIdentificacionId;
    private String cedula;
    private String nss;
    private String cedulaTitular;
    private String nombre;
    private String primerApellido;
    private Boolean automatica;
    private Long institucionPensionadoId;
    private Long claveInstitucionPensionado;
    private String estado;
    private Date fechaRecepcion;
    private Long municipioId;
    private Long ciudadanoId;
    private Date fechaUltimoCambio;

    public SolicitudAfiliacion(Long solicitudId, Integer servicioId, Integer loteId, Long entidadId, Long seguroId, Long regimenId, String tipoAfiliado, Short tipoIdentificacionId, String cedula, String nss, String cedulaTitular, String nombre, String primerApellido, Boolean automatica, Long institucionPensionadoId, Long claveInstitucionPensionado, String estado, Date fechaRecepcion, Long municipioId, Long ciudadanoId, Date fechaUltimoCambio) {
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
        this.cedulaTitular = cedulaTitular;
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