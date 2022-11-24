package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    protected static final Logger logger = LoggerFactory.getLogger(UserAuthenticationSuccessHandler.class);

    private final UsuarioService usuarioService;

    public UserAuthenticationSuccessHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("Entering in onAuthenticationSuccess");
        logger.info("Autenticated : "+ authentication.getName());
        Optional<Usuario> user = usuarioService.buscarUsuariosSistemaporCodigoJpa(authentication.getName());
        user.get().setFechaUltimoCambio(LocalDateTime.now());
        usuarioService.saveOrUpdateUser(user.get());
        response.sendRedirect(request.getContextPath());
    }
}
