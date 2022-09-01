package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.InstitucionPensionado;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value="/api/institucion/pensionado", produces=MediaType.APPLICATION_JSON_VALUE)
public class InstitucionPensionadoRestController {

    private static final Logger logger = LoggerFactory.getLogger(InstitucionPensionadoRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public InstitucionPensionadoRestController(CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<InstitucionPensionado> findById(@PathVariable("id") Long id){
        InstitucionPensionado institucionPensionado = catalogoService.buscarPorInstitucionPensionadoId(id);
        return new ResponseEntity(institucionPensionado, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<MotivoEstado>> findAll(){
        List<InstitucionPensionado> institucionPensionadoList = catalogoService.buscarInstitucionPensionadoTodas();
        return new ResponseEntity(institucionPensionadoList, HttpStatus.OK);
    }


}