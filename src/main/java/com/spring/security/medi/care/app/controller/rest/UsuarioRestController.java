package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.domain.Usuario;
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
@RequestMapping(value="/api/usuario/",produces=MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioRestController.class);

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController (UsuarioService usuarioService){
        this.usuarioService= usuarioService;
    }

    @GetMapping("/{codigo}")
    @ResponseBody
    public ResponseEntity<Usuario> findById(@PathVariable("codigo") String code){
        Usuario user = usuarioService.buscarUsuariosSistemaporCodigoJpa(code);
        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usersList = usuarioService.buscarUsuariosSistemaJpa();
        return new ResponseEntity<List<Usuario>>(usersList, HttpStatus.OK);
    }
}