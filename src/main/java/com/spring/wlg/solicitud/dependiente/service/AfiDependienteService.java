package com.spring.wlg.solicitud.dependiente.service;

import com.spring.wlg.solicitud.dependiente.domain.SolicitudDependiente;
import java.util.List;

public interface AfiDependienteService {

    List<SolicitudDependiente> buscarDependientePorInfoTitular(Long solicitudAfiTitular , String estado, String tipoDependiente);

}
