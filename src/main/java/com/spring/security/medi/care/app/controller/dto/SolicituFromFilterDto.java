package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class SolicituFromFilterDto implements Serializable{

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
