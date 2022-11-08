package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class UsuarioFormDTO implements Serializable {

    private static final long serialVersionUID = 5032108072315310780L;
    private String codigo;

    public UsuarioFormDTO(String codigo) {
        this.codigo = codigo;
    }

    public UsuarioFormDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "UsuarioFormDTO{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
