package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionService;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.controller.dto.DetalleSolicitudAfiliacionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/solicitud/afiliacion")
public class SolicitudAfiliacionRestController {

    private final SolicitudAfiliacionService solicitudAfiliacionService;

    @Autowired
    public SolicitudAfiliacionRestController (SolicitudAfiliacionService solicitudAfiliacionService){
        this.solicitudAfiliacionService= solicitudAfiliacionService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<SolicitudAfiliacion> findById(@PathVariable("id") Long id){
        SolicitudAfiliacion solicitud = solicitudAfiliacionService.buscarSolicitudAfiliacionPorId(id);
        return new ResponseEntity(solicitud, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<DetalleSolicitudAfiliacionDto> findDetailById(@PathVariable("id") Long id){
        DetalleSolicitudAfiliacionDto solicitud = solicitudAfiliacionService.buscarSolicitudAfiliacionDetallePorId(id);
        return new ResponseEntity(solicitud, HttpStatus.OK);
    }


}