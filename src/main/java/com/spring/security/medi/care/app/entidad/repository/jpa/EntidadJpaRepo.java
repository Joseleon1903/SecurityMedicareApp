package com.spring.security.medi.care.app.entidad.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly=true)
public interface EntidadJpaRepo extends JpaRepository<Entidad, Long>{

    @Query("select e from Entidad e where regimenId = :regimenId and participaAfiliacionAut = true")
    List<Entidad> findEntidadAfiliacionAutomatica(Integer regimenId);

}