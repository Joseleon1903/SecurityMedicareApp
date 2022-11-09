package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.MessageDigest;

@RestController
@RequestMapping(value="/api/security")
public class SecurityRestController {

    private static final Logger logger = LoggerFactory.getLogger(SecurityRestController.class);

    private final SecurityService securityService;

    @Autowired
    public SecurityRestController(SecurityService securityService){
        this.securityService= securityService;
    }

    @GetMapping("/generate/hash")
    @ResponseBody
    public ResponseEntity<String> GetgenerateHash(@RequestParam("texto") String texto) {
        logger.info("Entering in GetGenerateHash");
        logger.info("hash : 256");
        logger.info("Texto: "+ texto);
        String output = securityService.hash256String(texto);
        logger.info("Hash Output : "+ output);
        logger.info("Exiting in GetGenerateHash");
        return new ResponseEntity<String>(output.toLowerCase(), HttpStatus.OK);
    }





}
