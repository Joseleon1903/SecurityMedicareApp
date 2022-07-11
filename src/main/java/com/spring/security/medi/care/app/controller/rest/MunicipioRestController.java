package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.dto.MunicipioPaginatedDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value="/api/municipio/", produces=MediaType.APPLICATION_JSON_VALUE)
public class MunicipioRestController {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public MunicipioRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Municipio> findById(@PathVariable("id") Long id){
        Municipio municipio = catalogoService.buscarMunicipioPorId(id);
        return new ResponseEntity(municipio, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Municipio>> findAll(){
        List<Municipio> municipiosList = catalogoService.buscarMunicipiosTodos();
        return new ResponseEntity(municipiosList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Municipio> updateById(@RequestBody Municipio municipio){
        Municipio municipioOut = catalogoService.actualizarMunicipio(municipio);
        return new ResponseEntity(municipioOut, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<MunicipioPaginatedDto> findMunicipiosWithParameters(
            @RequestParam(value = "codigoMunicipio", required = false) String codigoMunicipio,
            @RequestParam(value = "descripcion", required = false) String descripcion,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size){
        MunicipioPaginatedDto municipiosPageable = catalogoService.buscarMunicipioPorParametros(codigoMunicipio, descripcion, page, size);
        return new ResponseEntity(municipiosPageable, HttpStatus.OK);
    }

}