package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MotivoEstadoJpaRepo extends JpaRepository<MotivoEstado, Long>{


    MotivoEstado findByMotivoId(Long motivoId);

    @Query("select m from MotivoEstado m order by m.motivoId asc")
    List<MotivoEstado> findAllMotivos();

}
