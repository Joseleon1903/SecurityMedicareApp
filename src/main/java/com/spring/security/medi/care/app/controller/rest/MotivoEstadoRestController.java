package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.catalogo.dto.MotivoEstadoPaginatedDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/motivoestado")
public class MotivoEstadoRestController {

    private static final Logger logger = LoggerFactory.getLogger(MotivoEstadoRestController.class);

    private final CatalogoService catalogoService;

    @Autowired
    public MotivoEstadoRestController (CatalogoService catalogoService){
        this.catalogoService= catalogoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MotivoEstado> findById(@PathVariable("id") Long id){
        return new ResponseEntity(catalogoService.buscarMotivoPorId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<MotivoEstado>> findAll(){
        return new ResponseEntity(catalogoService.buscarMotivosTodos(), HttpStatus.OK);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<MotivoEstado> updateEntity(@RequestBody MotivoEstado motivo){
        MotivoEstado motivoOut = catalogoService.actualizarMotivoEstado(motivo);
        return new ResponseEntity(motivoOut, HttpStatus.OK);
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<MotivoEstadoPaginatedDto> findMotivosWithParameters(
            @RequestParam(value = "motivoId", required = false) Long motivoId,
            @RequestParam(value = "descripcion", required = false) String descripcion,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size){
        MotivoEstadoPaginatedDto motivosPageable = catalogoService.buscarMotivosPorParametros(motivoId, descripcion, page, size);
        return new ResponseEntity(motivosPageable, HttpStatus.OK);
    }

}