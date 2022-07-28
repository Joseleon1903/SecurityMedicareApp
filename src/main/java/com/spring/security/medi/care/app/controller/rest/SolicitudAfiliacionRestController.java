package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value="/api/solicitud/afiliacion")
public class SolicitudAfiliacionRestController {


    private static final Logger logger = LoggerFactory.getLogger(SolicitudAfiliacionRestController.class);

    private final SolicitudAfiliacionService solicitudAfiliacionService;

    @Autowired
    public SolicitudAfiliacionRestController (SolicitudAfiliacionService solicitudAfiliacionService){
        this.solicitudAfiliacionService= solicitudAfiliacionService;
    }





}
