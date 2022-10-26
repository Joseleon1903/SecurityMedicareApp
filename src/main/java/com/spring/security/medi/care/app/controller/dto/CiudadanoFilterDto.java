package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class CiudadanoFilterDto implements Serializable {

    private static final long serialVersionUID = 6241179542950394650L;

    private String nombre;
    private String tipoIdentificacion;
    private String estado;

    public CiudadanoFilterDto(String nombre, String tipoIdentificacion, String estado) {
        this.nombre = nombre;
        this.tipoIdentificacion = tipoIdentificacion;
        this.estado = estado;
    }

    public CiudadanoFilterDto() {
    }


}