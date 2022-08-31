package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.TipoUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoUsuarioService {

    List<TipoUsuario> buscarTodosTipoUsuario() ;

    TipoUsuario buscarTipoUsuarioPorId(Long id);

}
