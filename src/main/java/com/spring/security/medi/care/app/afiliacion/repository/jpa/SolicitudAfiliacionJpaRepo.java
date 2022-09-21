package com.spring.security.medi.care.app.afiliacion.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public interface SolicitudAfiliacionJpaRepo extends JpaRepository<SolicitudAfiliacion, Long> {

    @Query("select s from SolicitudAfiliacion s where (:cedula is null or s.cedula like :cedula) " +
            " and (:servicioId is null or s.servicioId = :servicioId)" +
            " and (:seguroId is null or s.seguroId = :seguroId)" +
            " and (:regimenId is null or s.regimenId = :regimenId)" +
            " and (:estado is null or s.estado = :estado) order by s.solicitudId desc")
    Page<SolicitudAfiliacion> findSolicitudAfiliacionesByParameters(
            String cedula, Integer servicioId, Long seguroId, Integer regimenId, String estado,
            Pageable paging);
}
