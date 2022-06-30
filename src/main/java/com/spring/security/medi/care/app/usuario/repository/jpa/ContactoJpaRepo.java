package com.spring.security.medi.care.app.usuario.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactoJpaRepo extends JpaRepository<Contacto, Long>{

    Contacto findByContactoId(Long contactoId);

    List<Contacto> findAll();
}
