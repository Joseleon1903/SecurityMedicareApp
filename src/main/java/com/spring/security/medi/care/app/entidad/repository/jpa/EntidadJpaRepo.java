package com.spring.security.medi.care.app.entidad.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadJpaRepo extends JpaRepository<Entidad, Long>{
}
