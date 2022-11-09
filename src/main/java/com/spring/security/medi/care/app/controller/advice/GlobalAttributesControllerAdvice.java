package com.spring.security.medi.care.app.controller.advice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalAttributesControllerAdvice {

    @Value("${application.version}")
    private String version;

    @ModelAttribute("version")
    public String getVersion() {
        return version;
    }

}