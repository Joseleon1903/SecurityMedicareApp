package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.ciudadano.type.CiudadanoPaginated;
import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/ciudadano")
public class CiudadanoRestController {

    private final CiudadanoService ciudadanoService;

    @Autowired
    public CiudadanoRestController (CiudadanoService ciudadanoService){
        this.ciudadanoService= ciudadanoService;
    }

    @GetMapping("/{ciudadanoId}")
    @ResponseBody
    public ResponseEntity<Ciudadano> findById(@PathVariable("ciudadanoId") Long id){
        return new ResponseEntity(ciudadanoService.buscarCiudadanoPorCiudadanoId(id), HttpStatus.OK);
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<Ciudadano> findByIdentifiacacion(@RequestParam(value = "cedula", required = false) String cedula,
                                                           @RequestParam(value = "nss",required = false) String nss){
        return new ResponseEntity(ciudadanoService.buscarCiudadanoPorIdentifiacion(cedula, nss), HttpStatus.OK);
    }

    @GetMapping("/find/parameters")
    @ResponseBody
    public ResponseEntity<CiudadanoPaginated> findCiudadanosByParameters(@RequestParam(value = "tipoIdentificacion", required = false) String tipoIdentificacion,
                                                      @RequestParam(value = "texto", required = false) String texto,
                                                      @RequestParam(value = "estado",required = false) String estado){
        int page = DaoUtil.DEFAULT_PAGE;
        int size = DaoUtil.DEFAULT_ROW_COUNT;
        CiudadanoPaginated ciudadanoPaginated = ciudadanoService.buscarCiudadanosPorParametros(tipoIdentificacion, texto, estado, page, size);
        return new ResponseEntity(ciudadanoPaginated, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Ciudadano>> findAll(){
        List<Ciudadano> ciudadanos = ciudadanoService.buscarTodosCiudadanos();
        return new ResponseEntity(ciudadanos, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Ciudadano> registerCiudadano(@RequestBody Ciudadano ciudadano){
        Ciudadano ciudOut = ciudadanoService.guardarCiudadano(ciudadano);
        return new ResponseEntity(ciudOut, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{ciudadanoId}")
    @ResponseBody
    public ResponseEntity<Void> deleteById(@PathVariable("ciudadanoId") Long id){
        ciudadanoService.eliminarCiudadanoId(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}