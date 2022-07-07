package com.spring.security.medi.care.app.solicitud.titular.service;

import com.spring.security.medi.care.app.solicitud.titular.types.SolicitudTitular;

import java.util.List;

public interface AfiTitularService {

    public List<SolicitudTitular> buscarSolicitudesTitularPorCiudadano(Long ciuddanoId, String estado,
                                                                       Long numeroContrato, Short tipoPersona, Integer entidadId);

}
