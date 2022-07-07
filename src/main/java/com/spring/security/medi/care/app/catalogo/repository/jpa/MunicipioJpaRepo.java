package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Municipio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioJpaRepo extends JpaRepository<Municipio, Long>{

    Municipio findByMunicipioId(Long municipioId);

    List<Municipio> findAll();

}
