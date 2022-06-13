package com.spring.security.medi.care.app.solicitud.titular.service;

import com.spring.security.medi.care.app.solicitud.dependiente.service.AfiDependienteServiceImpl;
import com.spring.security.medi.care.app.solicitud.titular.domain.SolicitudTitular;
import com.spring.security.medi.care.app.solicitud.titular.repository.AfiTitularJdbcImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AfiTitularServiceImpl implements AfiTitularService {

    private static final Logger logger = LoggerFactory.getLogger(AfiDependienteServiceImpl.class);

    private final AfiTitularJdbcImpl afiDependienteJdbc;

    @Autowired
    public AfiTitularServiceImpl(AfiTitularJdbcImpl afiDependienteJdbc) {
        this.afiDependienteJdbc = afiDependienteJdbc;
    }

    @Override
    public List<SolicitudTitular> buscarSolicitudesTitularPorCiudadano(Long ciuddanoId, String estado, Long numeroContrato, Short tipoPersona, Integer entidadId) {
        return this.afiDependienteJdbc.buscarSolicitudesTitularPorCiudadano(ciuddanoId, estado, numeroContrato, tipoPersona, entidadId);
    }
}
