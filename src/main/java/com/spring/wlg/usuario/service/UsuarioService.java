package com.spring.wlg.usuario.service;

import com.spring.wlg.usuario.domain.UnipagoUsuario;
import com.spring.wlg.usuario.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> buscarusuariosSistema();

    List<UnipagoUsuario> buscarusuariosSistemaporCodigo(String codigo);

}
