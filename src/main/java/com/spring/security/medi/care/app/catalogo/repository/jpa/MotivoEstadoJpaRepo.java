package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly=true)
public interface MotivoEstadoJpaRepo extends JpaRepository<MotivoEstado, Long>{

    Optional<MotivoEstado> findByMotivoId(Long motivoId);

    @Query("select m from MotivoEstado m order by m.motivoId asc")
    Optional<List<MotivoEstado>> findAllMotivos();

    @Query("select m from MotivoEstado m where (:motivoId is null or m.motivoId = :motivoId) and (:descripcion is null or m.descripcion like :descripcion) order by m.motivoId asc")
    Page<MotivoEstado> findMotivosByParameters(Long motivoId, String descripcion, Pageable paging);

}