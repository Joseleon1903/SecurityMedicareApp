package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> buscarusuariosSistema();

    List<UnipagoUsuario> buscarusuariosSistemaporCodigo(String codigo);

    List<Usuario> buscarUsuariosSistemaJpa();

    Usuario buscarUsuariosSistemaporCodigoJpa(String codigo);

    Usuario saveOrUpdateUser(Usuario user);

    Usuario buscarUsuarioPorId(Long id);
}
