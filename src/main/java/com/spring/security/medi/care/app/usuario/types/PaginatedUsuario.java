package com.spring.security.medi.care.app.usuario.types;

import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.controller.dto.UsuarioDto;
import lombok.Data;
import java.util.List;

@Data
public class PaginatedUsuario {

    private List<UsuarioDto> usuarios;
    private PaginationOutput pagination;

    public PaginatedUsuario(List<UsuarioDto> usuarios, PaginationOutput pagination) {
        this.usuarios = usuarios;
        this.pagination = pagination;
    }

    public PaginatedUsuario() {
    }


}
