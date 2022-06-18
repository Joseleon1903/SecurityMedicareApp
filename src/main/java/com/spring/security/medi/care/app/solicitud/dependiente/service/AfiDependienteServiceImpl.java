package com.spring.security.medi.care.app.solicitud.dependiente.service;

import com.spring.security.medi.care.app.solicitud.dependiente.domain.SolicitudDependiente;
import com.spring.security.medi.care.app.solicitud.dependiente.repository.AfiDependienteJdbcImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfiDependienteServiceImpl implements AfiDependienteService{

    private static final Logger logger = LoggerFactory.getLogger(AfiDependienteServiceImpl.class);

    private final AfiDependienteJdbcImpl afiDependienteJdbc;

    @Autowired
    public AfiDependienteServiceImpl(AfiDependienteJdbcImpl afiDependienteJdbc) {
        this.afiDependienteJdbc = afiDependienteJdbc;
    }

    @Override
    public List<SolicitudDependiente> buscarDependientePorInfoTitular(Long solicitudAfiTitular, String estado, String tipoDependiente) {
        return afiDependienteJdbc.buscarDependientePorInfoTitular(solicitudAfiTitular, estado, tipoDependiente);
    }
}
