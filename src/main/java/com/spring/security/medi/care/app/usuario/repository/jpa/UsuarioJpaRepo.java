package com.spring.security.medi.care.app.usuario.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioJpaRepo extends JpaRepository<Usuario, Long>{

    Usuario findByCodigo(String codigo);

    List<Usuario> findAll();

}
