package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.usuario.domain.UnipagoUsuario;
import com.spring.security.medi.care.app.usuario.domain.Usuario;
import com.spring.security.medi.care.app.usuario.repository.UsuarioJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService{


    private final UsuarioJdbcImpl usuarioJdbc;

    @Autowired
    public UsuarioServiceImpl(UsuarioJdbcImpl usuarioJdbc) {
        this.usuarioJdbc = usuarioJdbc;
    }


    @Override
    public List<Usuario> buscarusuariosSistema() {
        return usuarioJdbc.buscarUsuarios();
    }

    @Override
    public List<UnipagoUsuario> buscarusuariosSistemaporCodigo(String codigo) {
        return usuarioJdbc.buscarUsuariosPorCodigo(codigo);
    }
}
