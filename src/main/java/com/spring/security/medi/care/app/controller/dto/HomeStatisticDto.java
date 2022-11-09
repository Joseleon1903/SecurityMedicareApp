package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class HomeStatisticDto implements Serializable {

    private static final long serialVersionUID = -8244018043349983085L;

    private int ciudadanoCounter;
    private int usuarioCounter;
    private int solicitudesCounter;
    private int entidadCounter;

    public HomeStatisticDto(int ciudadanoCounter, int usuarioCounter, int solicitudesCounter, int entidadCounter) {
        this.ciudadanoCounter = ciudadanoCounter;
        this.usuarioCounter = usuarioCounter;
        this.solicitudesCounter = solicitudesCounter;
        this.entidadCounter = entidadCounter;
    }

    public HomeStatisticDto() {
        this.ciudadanoCounter = 0;
        this.usuarioCounter = 0;
        this.solicitudesCounter = 0;
        this.entidadCounter = 0;
    }

    @Override
    public String toString() {
        return "HomeStatisticDto{" +
                "ciudadanoCounter=" + ciudadanoCounter +
                ", usuarioCounter=" + usuarioCounter +
                ", solicitudesCounter=" + solicitudesCounter +
                ", entidadCounter=" + entidadCounter +
                '}';
    }
}
