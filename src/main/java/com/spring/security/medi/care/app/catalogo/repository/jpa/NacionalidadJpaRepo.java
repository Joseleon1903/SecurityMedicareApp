package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NacionalidadJpaRepo extends JpaRepository<Nacionalidad, Long>{

    Nacionalidad findByNacionalidadId(Long motivoId);

    List<Nacionalidad> findAll();

    @Query("select n from Nacionalidad n where :paisId is null or n.paisId like :paisId order by n.nacionalidadId asc")
    Page<Nacionalidad> findNacionalidadByParameters(String paisId, Pageable paging);
}
