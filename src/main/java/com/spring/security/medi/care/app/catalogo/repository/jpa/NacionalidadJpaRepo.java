package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import com.spring.security.medi.care.app.commons.domain.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NacionalidadJpaRepo extends JpaRepository<Nacionalidad, Long>{

    Nacionalidad findByNacionalidadId(Long motivoId);

    List<Nacionalidad> findAll();
}
