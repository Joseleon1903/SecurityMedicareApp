package com.spring.wlg.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class UsuarioFormDTO {

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
