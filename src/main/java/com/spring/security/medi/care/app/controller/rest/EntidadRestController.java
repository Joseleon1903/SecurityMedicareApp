package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.domain.Entidad;
import com.spring.security.medi.care.app.entidad.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/entidad")
public class EntidadRestController {

    private final EntidadService entidadService;

    @Autowired
    public EntidadRestController(EntidadService entidadService){
        this.entidadService = entidadService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Entidad> findById(@PathVariable("id") Long id){
        Entidad entidad = entidadService.buscarEntidadPorId(id);
        return new ResponseEntity(entidad, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Entidad>> findAll(){
        List<Entidad> entidadList = entidadService.buscarEntidades();
        return new ResponseEntity(entidadList, HttpStatus.OK);
    }

    @GetMapping("/automatica")
    @ResponseBody
    public ResponseEntity<Entidad> asignarEntidadAutomatica(@RequestParam("regimenId") Integer regimenId){
        Entidad entidad = entidadService.asignarAutomaticamenteEntidad(regimenId);
        return new ResponseEntity(entidad, HttpStatus.OK);
    }
}
