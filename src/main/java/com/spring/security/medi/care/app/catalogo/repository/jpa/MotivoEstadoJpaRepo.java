package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MotivoEstadoJpaRepo extends JpaRepository<MotivoEstado, Long>{


    MotivoEstado findByMotivoId(Long motivoId);

    List<MotivoEstado> findAll();

}
