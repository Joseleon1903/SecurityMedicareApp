package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.dto.NacionalidadPaginatedDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value="/api/nacionalidad")
public class NacionalidadRestController {

    private static final Logger logger = LoggerFactory.getLogger(NacionalidadRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public NacionalidadRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Nacionalidad> findById(@PathVariable("id") Long id){
        Nacionalidad nacionalidad = catalogoService.buscarNacionalidadPorId(id);
        return new ResponseEntity<Nacionalidad>(nacionalidad, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Nacionalidad>> findAll(){
        List<Nacionalidad> nacionalidadesList = catalogoService.buscarNacionalidadTodos();
        return new ResponseEntity(nacionalidadesList, HttpStatus.OK);
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<NacionalidadPaginatedDto> findNacionalidadWithParameters(
            @RequestParam(value = "paisId", required = false) String paisId,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size){
        NacionalidadPaginatedDto nacionalidadesPageable = catalogoService.buscarNacionalidadPorParametros(paisId.toUpperCase(), page, size);
        return new ResponseEntity(nacionalidadesPageable, HttpStatus.OK);
    }


}