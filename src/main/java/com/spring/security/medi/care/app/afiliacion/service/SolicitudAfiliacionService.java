package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;

import java.util.List;

public interface SolicitudAfiliacionService {

    List<SolicitudAfiliacion> buscarSolicitudesAfiliacion();

    SolicitudAfiliacion regristarSolicitudAfiliacion(SolicitudAfiliacion solicitud) throws Exception;

}