package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.usuario.types.PaginatedUsuario;
import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {

    List<Usuario> buscarusuariosSistema();

    List<UnipagoUsuario> buscarUsuariosSistemaporCodigo(String codigo);

    List<Usuario> buscarUsuariosSistemaJpa();

    Usuario buscarUsuariosSistemaporCodigoJpa(String codigo);

    Usuario saveOrUpdateUser(Usuario user);

    Usuario buscarUsuarioPorId(Long id);

    PaginatedUsuario buscarUsuariosPorParametros(Long usuarioId, String codigo, String estado, int page, int size );

}
