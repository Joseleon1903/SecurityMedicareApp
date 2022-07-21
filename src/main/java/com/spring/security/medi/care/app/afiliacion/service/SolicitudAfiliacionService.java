package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;

import java.util.List;

public interface SolicitudAfiliacionService {

    List<SolicitudAfiliacion> buscarSolicitudesAfiliacion();

    SolicitudAfiliacion regristarSolicitudAfiliacion(SolicitudAfiliacion solicitud) throws Exception;

    List<SolicitudAfiliacion> buscarSolicitudesAfiliacionPorParametros(String cedula,Integer servicioId, Long seguroId, Long regimenId, String estado, int page, int size);

    void procesarSolicitudAfiliacion(Long solicitudId) throws Exception;

}