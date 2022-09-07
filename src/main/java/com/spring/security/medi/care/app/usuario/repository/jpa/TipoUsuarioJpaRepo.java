package com.spring.security.medi.care.app.usuario.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public interface TipoUsuarioJpaRepo extends JpaRepository<TipoUsuario, Long> {
}
