package com.spring.security.medi.care.app.usuario.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly=true)
public interface ContactoJpaRepo extends JpaRepository<Contacto, Long>{

    Optional<Contacto> findByContactoId(Long contactoId);

    List<Contacto> findAll();
}
