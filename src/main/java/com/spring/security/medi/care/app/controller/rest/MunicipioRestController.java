package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.Municipio;
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
@RequestMapping("/api/municipio/")
public class MunicipioRestController {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public MunicipioRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Municipio> findById(@PathVariable("id") Long id){
        Municipio municipio = catalogoService.buscarMunicipioPorId(id);
        return new ResponseEntity<Municipio>(municipio, HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Municipio>> findAll(){
        List<Municipio> municipiosList = catalogoService.buscarMunicipiosTodos();
        return new ResponseEntity<List<Municipio>>(municipiosList, HttpStatus.OK);
    }

}
