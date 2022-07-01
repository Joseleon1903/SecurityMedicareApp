package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.GradoConsanguinidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoConsanguinidadJpaRepo extends JpaRepository<GradoConsanguinidad, Long>{

    GradoConsanguinidad findByGradoConsanguinidadId(Long GradoConsanguinidadId);

    List<GradoConsanguinidad> findAll();


}
