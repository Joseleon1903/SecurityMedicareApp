package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.domain.Contacto;
import com.spring.security.medi.care.app.usuario.service.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/contacto")
public class ContactoRestController {


    private static final Logger logger = LoggerFactory.getLogger(ContactoRestController.class);

    private final ContactoService contactoService;

    @Autowired
    public ContactoRestController (ContactoService contactoService){
        this.contactoService= contactoService;
    }

    @GetMapping("/{contactoId}")
    @ResponseBody
    public ResponseEntity<Contacto> findById(@PathVariable("contactoId") Long id){
        Contacto contacto = contactoService.buscarContactoPorId(id);
        return new ResponseEntity(contacto, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Contacto>> findAll(){
        List<Contacto> contactosList = contactoService.buscarContactosSistema();
        return new ResponseEntity(contactosList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Contacto> saveContacto(@RequestBody Contacto contacto){
       Contacto contactoOutput = contactoService.guardarContacto(contacto);
        return new ResponseEntity(contactoOutput, HttpStatus.OK);
    }





}