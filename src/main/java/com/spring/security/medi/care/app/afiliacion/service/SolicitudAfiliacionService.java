package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.controller.dto.DetalleSolicitudAfiliacionDto;

import java.util.List;

public interface SolicitudAfiliacionService {

    List<SolicitudAfiliacion> buscarSolicitudesAfiliacion();

    SolicitudAfiliacion regristarSolicitudAfiliacion(SolicitudAfiliacion solicitud) throws Exception;

    SolicitudAfiliacion buscarSolicitudAfiliacionPorId(Long solicitudId);

    List<SolicitudAfiliacion> buscarSolicitudesAfiliacionPorParametros(String cedula, Integer servicioId, Long seguroId,
            Integer regimenId, String estado, int page, int size);

    void procesarSolicitudAfiliacion(Long solicitudId) throws Exception;

    DetalleSolicitudAfiliacionDto buscarSolicitudAfiliacionDetallePorId(Long id);
}