package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.InstitucionPensionado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/institucion/pensionado", produces=MediaType.APPLICATION_JSON_VALUE)
public class InstitucionPensionadoRestController {

    private final CatalogoService catalogoService;

    @Autowired
    public InstitucionPensionadoRestController(CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<InstitucionPensionado> findById(@PathVariable("id") Long id){
        return new ResponseEntity(catalogoService.buscarPorInstitucionPensionadoId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<InstitucionPensionado>>findAll(){
        return new ResponseEntity(catalogoService.buscarInstitucionPensionadoTodas(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<InstitucionPensionado> saveOrUpdate(@RequestBody InstitucionPensionado institucionPensionado) {
        InstitucionPensionado intitucionOutput = catalogoService.guardarInstitucionPensionado(institucionPensionado);
        return new ResponseEntity(intitucionOutput, HttpStatus.OK);
    }

}