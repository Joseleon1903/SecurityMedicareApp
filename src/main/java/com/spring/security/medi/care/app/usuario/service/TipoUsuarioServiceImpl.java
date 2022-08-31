package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.TipoUsuario;
import com.spring.security.medi.care.app.usuario.repository.jpa.TipoUsuarioJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

    private final TipoUsuarioJpaRepo tipoUsuarioJpaRepo;

    @Autowired
    public TipoUsuarioServiceImpl(TipoUsuarioJpaRepo tipoUsuarioJpaRepo) {
        this.tipoUsuarioJpaRepo = tipoUsuarioJpaRepo;
    }

    @Override
    public List<TipoUsuario> buscarTodosTipoUsuario() {
        return tipoUsuarioJpaRepo.findAll();
    }

    @Override
    public TipoUsuario buscarTipoUsuarioPorId(Long id) {
        return tipoUsuarioJpaRepo.findById(id).get();
    }

}
