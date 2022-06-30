package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.controller.page.AfiliacionTitularController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/motivoestado/")
public class MotivoEstadoRestController {

    private static final Logger logger = LoggerFactory.getLogger(MotivoEstadoRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public MotivoEstadoRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MotivoEstado> findById(@PathVariable("id") Long id){
        MotivoEstado motivo = catalogoService.buscarMotivoPorId(id);
        return new ResponseEntity<MotivoEstado>(motivo, HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<MotivoEstado>> findAll(){
        List<MotivoEstado> motivosList = catalogoService.buscarMotivosTodos();
        return new ResponseEntity<List<MotivoEstado>>(motivosList, HttpStatus.OK);
    }

}