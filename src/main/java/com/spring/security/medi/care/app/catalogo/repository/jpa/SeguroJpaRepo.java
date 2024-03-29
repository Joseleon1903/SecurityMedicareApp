package com.spring.security.medi.care.app.catalogo.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly=true)
public interface SeguroJpaRepo extends JpaRepository<Seguro, Long> {

    Optional<Seguro> findBySeguroId(Long seguroId);
}
