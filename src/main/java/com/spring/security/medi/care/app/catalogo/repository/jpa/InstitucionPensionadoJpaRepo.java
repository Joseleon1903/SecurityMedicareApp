package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.InstitucionPensionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InstitucionPensionadoJpaRepo extends JpaRepository<InstitucionPensionado, Long>{

    @Query("select i from InstitucionPensionado i order by i.institucionPensionadoId asc")
    List<InstitucionPensionado> findAllInstitucionPensionados();
}
