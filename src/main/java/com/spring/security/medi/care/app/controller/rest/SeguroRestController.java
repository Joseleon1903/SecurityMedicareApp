package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.Seguro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "/api/seguro")
public class SeguroRestController {

    private static final Logger logger = LoggerFactory.getLogger(SeguroRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public SeguroRestController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Seguro> findById(@PathVariable("id") Long id) {
        Seguro seguroOut = catalogoService.buscarSegurosSistemaPorId(id);
        return new ResponseEntity<Seguro>(seguroOut, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Seguro>> findAll() {
        List<Seguro> segurosList = catalogoService.buscarSegurosSistema();
        return new ResponseEntity<List<Seguro>>(segurosList, HttpStatus.OK);
    }

}
