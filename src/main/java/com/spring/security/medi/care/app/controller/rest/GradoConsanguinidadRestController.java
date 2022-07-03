package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.GradoConsanguinidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gradoconsanguinidad/")
public class GradoConsanguinidadRestController {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public GradoConsanguinidadRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<GradoConsanguinidad> findById(@PathVariable("id") Long id){
        GradoConsanguinidad grado = catalogoService.buscarGradoConsanguinidadPorId(id);
        return new ResponseEntity<GradoConsanguinidad>(grado, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<GradoConsanguinidad>> findAll(){
        List<GradoConsanguinidad> gradosList = catalogoService.buscarGradoConsanguinidadesTodos();
        return new ResponseEntity<List<GradoConsanguinidad>>(gradosList, HttpStatus.ACCEPTED);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<GradoConsanguinidad> updateEntity(@RequestBody GradoConsanguinidad grado){
        GradoConsanguinidad responseGrado = catalogoService.actualizarGradoConsanguinidad(grado);
        return new ResponseEntity<GradoConsanguinidad>(responseGrado, HttpStatus.OK);
    }

}
