package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.commons.service.SecurityService;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import com.spring.security.medi.care.app.usuario.types.PaginatedUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value="/api/usuario")
public class UsuarioRestController {

    private final UsuarioService usuarioService;
    private final SecurityService securityService;

    @Autowired
    public UsuarioRestController (UsuarioService usuarioService, SecurityService securityService){
        this.usuarioService= usuarioService;
        this.securityService = securityService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
        Usuario user = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("/code/{codigo}")
    @ResponseBody
    public ResponseEntity<Usuario> findByCode(@PathVariable("codigo") String code) {
        Usuario user = usuarioService.buscarUsuariosSistemaporCodigoJpa(code);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usersList = usuarioService.buscarUsuariosSistemaJpa();
        return new ResponseEntity(usersList, HttpStatus.OK);
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<PaginatedUsuario> findUsuarioByParameters(@RequestParam(value = "usuarioId", required = false) Long usuarioId,
                                                                    @RequestParam(value = "codigo", required = false) String codigo,
                                                                    @RequestParam(value = "estado", required = false) String estado,
                                                                    @RequestParam(value = "page") int page,
                                                                    @RequestParam(value = "size") int size){
        PaginatedUsuario usersList = usuarioService.buscarUsuariosPorParametros(usuarioId, codigo, estado, page, size);
        return new ResponseEntity(usersList, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario user){
        String texto = user.getCodigo() + new Random().nextInt(50000);
        String llave = securityService.hash256String(texto);
        user.setLlaveEncriptacion(llave);
        Usuario userOutput = usuarioService.saveOrUpdateUser(user);
        return new ResponseEntity(userOutput, HttpStatus.OK);
    }
}