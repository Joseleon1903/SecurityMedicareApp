package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import com.spring.security.medi.care.app.usuario.types.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> buscarusuariosSistema();

    List<UnipagoUsuario> buscarusuariosSistemaporCodigo(String codigo);

}
