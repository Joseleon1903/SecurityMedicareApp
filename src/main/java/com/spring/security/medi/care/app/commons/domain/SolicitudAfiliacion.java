package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
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
    private LocalDate fechaRecepcion;
    private Long municipioId;
    private Long ciudadanoId;
    private Long nacionalidadId;
    private LocalDateTime fechaUltimoCambio;
    private Long motivoId;

    public SolicitudAfiliacion(Long solicitudId, ServicioSistema servicioId, Integer loteId, Entidad entidadId, Seguro seguroId,
            Integer regimenId, String tipoAfiliado, Short tipoIdentificacionId, String cedula, String nss,
            String nombre, String primerApellido, Boolean automatica,
            Long institucionPensionadoId, Long claveInstitucionPensionado, String estado, LocalDate fechaRecepcion,
            Long municipioId, Long ciudadanoId, Long nacionalidadId, LocalDateTime fechaUltimoCambio) {
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