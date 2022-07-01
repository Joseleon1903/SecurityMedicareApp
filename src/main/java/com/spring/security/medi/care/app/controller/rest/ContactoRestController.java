package com.spring.security.medi.care.app.controller.rest;

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
@RequestMapping("/api/contacto/")
public class ContactoRestController {


    private static final Logger logger = LoggerFactory.getLogger(ParentescoRestController.class);

    private final ContactoService contactoService;

    @Autowired
    public ContactoRestController (ContactoService contactoService){
        this.contactoService= contactoService;
    }

    @RequestMapping(value="/{contactoId}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Contacto> findById(@PathVariable("contactoId") Long id){
        Contacto contacto = contactoService.buscarContactoPorId(id);
        return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Contacto>> findAll(){
        List<Contacto> contactosList = contactoService.buscarContactosSistema();
        return new ResponseEntity<List<Contacto>>(contactosList, HttpStatus.OK);
    }







}
