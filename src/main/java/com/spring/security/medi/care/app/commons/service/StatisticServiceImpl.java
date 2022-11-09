package com.spring.security.medi.care.app.commons.service;

import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionService;
import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.controller.dto.HomeStatisticDto;
import com.spring.security.medi.care.app.entidad.service.EntidadService;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService{

    private final CiudadanoService ciudadanoService;
    private final UsuarioService usuarioService;
    private final SolicitudAfiliacionService solicitudAfiliacionService;
    private final EntidadService entidadService;

    @Autowired
    public StatisticServiceImpl(CiudadanoService ciudadanoService, UsuarioService usuarioService, SolicitudAfiliacionService solicitudAfiliacionService, EntidadService entidadService) {
        this.ciudadanoService = ciudadanoService;
        this.usuarioService = usuarioService;
        this.solicitudAfiliacionService = solicitudAfiliacionService;
        this.entidadService = entidadService;
    }

    @Override
    public HomeStatisticDto buscarHomeStatisticDto() {
         int ciudadanoCounter = ciudadanoService.buscarTodosCiudadanos().size();
         int usuarioCounter = usuarioService.buscarUsuariosSistemaJpa().size();
         int solicitudesCounter = solicitudAfiliacionService.buscarSolicitudesAfiliacion().size();
         int entidadCounter = entidadService.buscarEntidades().size();
        return new HomeStatisticDto(ciudadanoCounter, usuarioCounter, solicitudesCounter, entidadCounter);
    }
}
