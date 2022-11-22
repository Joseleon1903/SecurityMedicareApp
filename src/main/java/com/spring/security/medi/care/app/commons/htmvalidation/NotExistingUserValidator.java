package com.spring.security.medi.care.app.commons.htmvalidation;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.controller.dto.CreateUserFormData;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotExistingUserValidator implements ConstraintValidator<NotExistingUser, CreateUserFormData> {

    private static final Logger logger = LoggerFactory.getLogger(NotExistingUserValidator.class);

    private final UsuarioService usuarioService;

    @Autowired
    public NotExistingUserValidator(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void initialize(NotExistingUser constraintAnnotation) {
        // intentionally empty
    }

    @Override
    public boolean isValid(CreateUserFormData createUserFormData, ConstraintValidatorContext constraintValidatorContext) {
        logger.info("Entering in isValid");
        logger.info("createUserFormData : "+createUserFormData);

        Optional<Usuario> user = usuarioService.buscarUsuariosSistemaporCodigoJpa(createUserFormData.getUsername());

        if(!user.isPresent()  && user.get().getCodigo().toUpperCase().equals(createUserFormData.getUsername())){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{UserAlreadyExisting}").addPropertyNode("correoprimario").addConstraintViolation();
            return false;
        }

         user = usuarioService.buscarUsuariosSistemaPorEmailJpa(createUserFormData.getCorreoprimario());

        if(!user.isPresent()  && user.get().getContactoId().getCorreoPrimario().toUpperCase().equals(createUserFormData.getCorreoprimario())){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{UserAlreadyExisting}").addPropertyNode("correoprimario").addConstraintViolation();
            return false;
        }
        return true;
    }
}
