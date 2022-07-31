package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Entidad implements Serializable {

    @Id
    private Long entidadId;
    private Long tipoEntidadId;
    private Integer claveEntidad;
    private String sigla;
    private String descripcion;
    private Integer regimenId;
    private Boolean participaAfiliacionAut;
    private String rnc;
    private Long entidadSupervisoraId;
    private String estado;
    private Integer municipioId;

    public Entidad() {}

    public Entidad(Long entidadId) {
        this.entidadId = entidadId;
    }

    public Entidad(Long entidadId, Long tipoEntidadId, Integer claveEntidad, String sigla, String descripcion, Integer regimenId, Boolean participaAfiliacionAutomatica, String rnc, Long entidadSupervisoraId, String estado, Integer municipioId) {
        this.entidadId = entidadId;
        this.tipoEntidadId = tipoEntidadId;
        this.claveEntidad = claveEntidad;
        this.sigla = sigla;
        this.descripcion = descripcion;
        this.regimenId = regimenId;
        this.participaAfiliacionAut = participaAfiliacionAutomatica;
        this.rnc = rnc;
        this.entidadSupervisoraId = entidadSupervisoraId;
        this.estado = estado;
        this.municipioId = municipioId;
    }
}
