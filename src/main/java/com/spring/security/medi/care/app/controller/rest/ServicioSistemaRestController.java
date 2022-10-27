package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.ServicioSistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "/api/servicio/sistema")
public class ServicioSistemaRestController {

    private final CatalogoService catalogoService;

    @Autowired
    public ServicioSistemaRestController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ServicioSistema> findById(@PathVariable("id") Long id) {
        ServicioSistema servicio = catalogoService.buscarServicioSistemaPorId(id);
        return new ResponseEntity(servicio, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ServicioSistema>> findAll() {
        List<ServicioSistema> servicioList = catalogoService.buscarServiciosSistemas();
        return new ResponseEntity(servicioList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ServicioSistema> persistServicioSistema(@RequestBody ServicioSistema servicioSistema) {
        ServicioSistema servicio = catalogoService.registrarServicioSistema(servicioSistema);
        return new ResponseEntity(servicio, HttpStatus.OK);
    }

}