package com.spring.security.medi.care.app.commons.service;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;

public class ApplicationMessageUtil {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private HttpServletRequest request;

    public ApplicationMessageUtil(MessageSource messageSource, LocaleResolver localeResolver, HttpServletRequest request) {
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
        this.request = request;
    }

    public String getMessage(String code){
        return messageSource.getMessage(code,null, localeResolver.resolveLocale(request));
    }

}