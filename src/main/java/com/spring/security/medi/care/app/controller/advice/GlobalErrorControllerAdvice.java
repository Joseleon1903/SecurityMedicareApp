package com.spring.security.medi.care.app.controller.advice;

import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.exception.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static com.spring.security.medi.care.app.commons.AplicationConstantUtil.GENERAL_ERROR_INTERNO;
import static com.spring.security.medi.care.app.commons.AplicationConstantUtil.INVALID_UPLOAD_FILE_EXCEPTION;

@ControllerAdvice
public class GlobalErrorControllerAdvice {

    protected static final Logger logger = LoggerFactory.getLogger(ViewBaseContext.class);

    @ExceptionHandler(value = { RuntimeException.class })
    protected String handleConflict(RuntimeException ex, WebRequest request, Model model) {
        String bodyOfResponse = "This should be application specific";
        logger.info("Entering in handleConflict : RuntimeException");
        logger.info("Error: "+ ex.getMessage());

        Long motivo = GENERAL_ERROR_INTERNO;
        if(ex instanceof InvalidFormatException){
            logger.info("found InvalidFormatException error");
            motivo = INVALID_UPLOAD_FILE_EXCEPTION;
        }
        model.addAttribute("ErrorCode", motivo);

        logger.info(bodyOfResponse);
        return "redirect:/general_error";
    }

}
