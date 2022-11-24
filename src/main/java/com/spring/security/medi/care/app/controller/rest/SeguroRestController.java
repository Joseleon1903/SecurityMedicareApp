package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.Seguro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/seguro")
public class SeguroRestController {

    private final CatalogoService catalogoService;

    @Autowired
    public SeguroRestController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Seguro> findById(@PathVariable("id") Long id) {
        return new ResponseEntity(catalogoService.buscarSegurosSistemaPorId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Seguro>> findAll() {
        List<Seguro> segurosList = catalogoService.buscarSegurosSistema();
        return new ResponseEntity(segurosList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Seguro> saveOrUpdate(@RequestBody Seguro seguro) {
        Seguro seguroOutput = catalogoService.guardarSeguroSistema(seguro);
        return new ResponseEntity(seguroOutput, HttpStatus.OK);
    }

}
