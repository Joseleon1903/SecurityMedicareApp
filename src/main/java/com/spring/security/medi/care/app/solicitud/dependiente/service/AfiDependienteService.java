package com.spring.security.medi.care.app.solicitud.dependiente.service;

import com.spring.security.medi.care.app.solicitud.dependiente.domain.SolicitudDependiente;
import java.util.List;

public interface AfiDependienteService {

    List<SolicitudDependiente> buscarDependientePorInfoTitular(Long solicitudAfiTitular , String estado, String tipoDependiente);

}
