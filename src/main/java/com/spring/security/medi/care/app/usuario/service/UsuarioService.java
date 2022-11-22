package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.controller.dto.GestionUsuarioStatisticDTO;
import com.spring.security.medi.care.app.usuario.types.PaginatedUsuario;
import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> buscarusuariosSistema();

    List<UnipagoUsuario> buscarUsuariosSistemaporCodigo(String codigo);

    List<Usuario> buscarUsuariosSistemaJpa();

    Optional<Usuario> buscarUsuariosSistemaporCodigoJpa(String codigo);

    Optional<Usuario> buscarUsuariosSistemaPorEmailJpa(String email);

    Usuario saveOrUpdateUser(Usuario user);

    void deleteUsuarioById(Long userId);

    Optional<Usuario> buscarUsuarioPorId(Long id);

    PaginatedUsuario buscarUsuariosPorParametros(Long usuarioId, String codigo, String estado, int page, int size );

    Optional<GestionUsuarioStatisticDTO> getSystemUserStatistic();

}
