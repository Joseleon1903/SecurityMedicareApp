package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentescoJpaRepo extends JpaRepository<Parentesco, Long>{

    Parentesco findByParentescoId(Long motivoId);

    List<Parentesco> findAll();

}
