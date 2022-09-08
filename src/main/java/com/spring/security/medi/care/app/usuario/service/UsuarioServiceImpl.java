package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.usuario.repository.jpa.UsuarioJpaRepo;
import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import com.spring.security.medi.care.app.usuario.repository.jdbc.UsuarioJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements  UsuarioService{

    private final UsuarioJdbcImpl usuarioJdbc;

    private final UsuarioJpaRepo usuarioJpaRepo;

    @Autowired
    public UsuarioServiceImpl(UsuarioJdbcImpl usuarioJdbc, UsuarioJpaRepo usuarioJpaRepo) {
        this.usuarioJdbc = usuarioJdbc;
        this.usuarioJpaRepo =usuarioJpaRepo;
    }

    @Override
    public List<Usuario> buscarusuariosSistema() {
        return null;
    }

    @Override
    public List<UnipagoUsuario> buscarusuariosSistemaporCodigo(String codigo) {
        return usuarioJdbc.buscarUsuariosPorCodigo(codigo);
    }

    @Override
    public List<Usuario> buscarUsuariosSistemaJpa(){
        return usuarioJpaRepo.findAll();
    }

    @Override
    public Usuario buscarUsuariosSistemaporCodigoJpa(String codigo){
        return usuarioJpaRepo.findByCodigo(codigo.toUpperCase());
    }

    @Override
    public Usuario saveOrUpdateUser(Usuario user){
        return usuarioJpaRepo.save(user);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id){
        return usuarioJpaRepo.findByUsuarioId(id);
    }

}
