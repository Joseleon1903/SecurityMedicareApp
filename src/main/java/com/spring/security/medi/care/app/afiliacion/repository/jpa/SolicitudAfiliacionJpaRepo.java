package com.spring.security.medi.care.app.afiliacion.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudAfiliacionJpaRepo extends JpaRepository<SolicitudAfiliacion, Long>{
}
