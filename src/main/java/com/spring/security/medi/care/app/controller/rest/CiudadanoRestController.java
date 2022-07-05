package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.commons.domain.Contacto;
import com.spring.security.medi.care.app.usuario.service.ContactoService;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value= "/api/ciudadano/" , produces=MediaType.APPLICATION_JSON_VALUE)
public class CiudadanoRestController {

    private static final Logger logger = LoggerFactory.getLogger(CiudadanoRestController.class);

    private final CiudadanoService ciudadanoService;

    @Autowired
    public CiudadanoRestController (CiudadanoService ciudadanoService){
        this.ciudadanoService= ciudadanoService;
    }

    @GetMapping("/{ciudadanoId}")
    @ResponseBody
    public ResponseEntity<Ciudadano> findById(@PathVariable("ciudadanoId") Long id){
        Ciudadano ciudadano = ciudadanoService.buscarCiudadanoPorCiudadanoId(id);
        return new ResponseEntity<Ciudadano>(ciudadano, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Ciudadano>> findAll(){
        List<Ciudadano> ciudadanos = ciudadanoService.buscarTodosCiudadanos();
        return new ResponseEntity<List<Ciudadano>>(ciudadanos, HttpStatus.ACCEPTED);
    }
}
