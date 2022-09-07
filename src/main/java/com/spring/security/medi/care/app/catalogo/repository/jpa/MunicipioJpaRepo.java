package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Municipio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public interface MunicipioJpaRepo extends JpaRepository<Municipio, Long>{

    Municipio findByMunicipioId(Long municipioId);

    List<Municipio> findAll();

    @Query("select m from Municipio m where (:codigoMunicipio is null or m.codigoMunicipio like :codigoMunicipio) and (:descripcion is null or m.descripcion like :descripcion) order by m.municipioId asc")
    Page<Municipio> findMotivosByParameters(String codigoMunicipio, String descripcion, Pageable paging);
}
