package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.InstitucionPensionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly=true)
public interface InstitucionPensionadoJpaRepo extends JpaRepository<InstitucionPensionado, Long>{

    @Query("select i from InstitucionPensionado i order by i.institucionPensionadoId asc")
    Optional<List<InstitucionPensionado>> findAllInstitucionPensionados();
}
