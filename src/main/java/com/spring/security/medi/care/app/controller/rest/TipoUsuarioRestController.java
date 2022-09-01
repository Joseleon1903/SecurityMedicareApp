package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.domain.TipoUsuario;
import com.spring.security.medi.care.app.usuario.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value="/api/tipousuario")
public class TipoUsuarioRestController {


    private static final Logger logger = LoggerFactory.getLogger(TipoUsuarioRestController.class);

    private final TipoUsuarioService tipoUsuarioService;

    @Autowired
    public TipoUsuarioRestController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TipoUsuario> findById(@PathVariable("id") Long id){
        logger.debug("Entering findById");
        TipoUsuario tipoU = tipoUsuarioService.buscarTipoUsuarioPorId(id);
        return new ResponseEntity(tipoU, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TipoUsuario>> findAll(){
        logger.debug("Entering findAll");
        logger.info("buscando todos los tipo usuario");
        List<TipoUsuario> tipoUsuarioList = tipoUsuarioService.buscarTodosTipoUsuario();
        return new ResponseEntity(tipoUsuarioList, HttpStatus.OK);
    }

}