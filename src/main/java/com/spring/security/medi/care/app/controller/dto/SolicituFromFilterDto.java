package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SolicituFromFilterDto implements Serializable{

    private static final long serialVersionUID = 4443438312137408841L;
    private String cedula;
    private Integer servicioId;
    private Long seguroId;
    private String regimenId;
    private String estado;

    public SolicituFromFilterDto(String cedula, Integer servicioId, Long seguroId, String regimenId, String estado) {
        this.cedula = cedula;
        this.servicioId = servicioId;
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.estado = estado;
    }

    public SolicituFromFilterDto() {
    }
}
