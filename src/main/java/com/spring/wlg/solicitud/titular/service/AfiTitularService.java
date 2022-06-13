package com.spring.wlg.solicitud.titular.service;

import com.spring.wlg.solicitud.titular.domain.SolicitudTitular;

import java.util.List;

public interface AfiTitularService {

    public List<SolicitudTitular> buscarSolicitudesTitularPorCiudadano(Long ciuddanoId, String estado,
                                                                       Long numeroContrato, Short tipoPersona, Integer entidadId);

}
