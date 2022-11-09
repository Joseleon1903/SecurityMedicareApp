package com.spring.security.medi.care.app.commons.htmvalidation;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.controller.dto.MotivoEstadoFormDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DupicatedMotivoEstadoValidator implements ConstraintValidator<DupicatedMotivoEstado, MotivoEstadoFormDTO> {

    private static final Logger logger = LoggerFactory.getLogger(DupicatedMotivoEstadoValidator.class);

    private final CatalogoService catalogoService;

    @Autowired
    public DupicatedMotivoEstadoValidator(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @Override
    public void initialize(DupicatedMotivoEstado constraintAnnotation) {
            // intentionally empty
    }

    @Override
    public boolean isValid(MotivoEstadoFormDTO motivoEstadoFormDTO, ConstraintValidatorContext constraintValidatorContext) {
        logger.info("Entering in DupicatedMotivoEstadoValidator: isValid");
        logger.info("param  in motivoEstadoFormDTO: "+motivoEstadoFormDTO);

        if(motivoEstadoFormDTO.getMotivoId() != null && catalogoService.buscarMotivoPorId(motivoEstadoFormDTO.getMotivoId()) != null){
            logger.info("returning : false");
            return false;
        }
        logger.info("returning : true");
        return true;
    }
}
