package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.controller.dto.ErrorPageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneralErrorController {

    protected static final Logger logger = LoggerFactory.getLogger(GeneralErrorController.class);

    private final CatalogoService catalogoService;

    public GeneralErrorController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/general_error")
    public String showPage(@RequestParam(value = "ErrorCode", required = false) Long errorCode, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage..");

        logger.info("ErrorCode: "+ errorCode);
        MotivoEstado mot = catalogoService.buscarMotivoPorId(errorCode).get();
        logger.info("MotivoEstado: "+ mot);
        model.addAttribute("ErrorPageBean", new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true));

        return "error/error";
    }

}
