package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
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
@RequestMapping("/api/nacionalidad/")
public class NacionalidadRestController {

    private static final Logger logger = LoggerFactory.getLogger(ParentescoRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public NacionalidadRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Nacionalidad> findById(@PathVariable("id") Long id){
        Nacionalidad nacionalidad = catalogoService.buscarNacionalidadPorId(id);
        return new ResponseEntity<Nacionalidad>(nacionalidad, HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Nacionalidad>> findAll(){
        List<Nacionalidad> nacionalidadesList = catalogoService.buscarNacionalidadTodos();
        return new ResponseEntity<List<Nacionalidad>>(nacionalidadesList, HttpStatus.OK);
    }

}
