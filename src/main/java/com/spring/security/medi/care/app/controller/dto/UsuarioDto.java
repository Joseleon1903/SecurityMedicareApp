package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import java.util.Date;

@Data
public class UsuarioDto {

    private Long usuarioId;
    private String nombre;
    private String tipoUsuarioId;
    private String correoPrimario;
    private Date fechaUltimoCambio;
    private String estado;

    public UsuarioDto(Long usuarioId, String nombre, String tipoUsuarioId, String correoPrimario, Date fechaUltimoCambio, String estado) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.tipoUsuarioId = tipoUsuarioId;
        this.correoPrimario = correoPrimario;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }

    public UsuarioDto() {
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", tipoUsuarioId='" + tipoUsuarioId + '\'' +
                ", correoPrimario='" + correoPrimario + '\'' +
                ", fechaUltimoCambio=" + fechaUltimoCambio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
