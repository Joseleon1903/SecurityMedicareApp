package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroJpaRepo extends JpaRepository<Seguro, Long> {

    Seguro findBySeguroId(Long seguroId);
}
