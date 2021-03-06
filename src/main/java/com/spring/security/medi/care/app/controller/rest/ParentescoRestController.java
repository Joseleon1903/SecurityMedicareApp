package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.Parentesco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value="/api/parentesco/",produces=MediaType.APPLICATION_JSON_VALUE)
public class ParentescoRestController {


    private static final Logger logger = LoggerFactory.getLogger(ParentescoRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public ParentescoRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Parentesco> findById(@PathVariable("id") Long id){
        Parentesco parentesco = catalogoService.buscarParentescoPorId(id);
        return new ResponseEntity<Parentesco>(parentesco, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Parentesco>> findAll(){
        List<Parentesco> parentescosList = catalogoService.buscarParentescoTodos();
        return new ResponseEntity<List<Parentesco>>(parentescosList, HttpStatus.OK);
    }

}
