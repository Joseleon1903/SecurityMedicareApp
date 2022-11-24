package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.ApplicationUserDetails;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.controller.page.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional(readOnly = true)
public class DatabaseUserDetailsService implements UserDetailsService {

    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UsuarioService usuarioService;

    private Optional<Usuario> userDetail;

    @Autowired
    public DatabaseUserDetailsService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Entring in loadUserByUsername");
        logger.info("param username: "+ username);

        logger.info("init search of user");
        usuarioService.buscarUsuariosSistemaporCodigoJpa(username).ifPresentOrElse( (us) -> {
            userDetail=  Optional.of(us);
        },() ->{ throw new UsernameNotFoundException("User with email %s could not be found");});
        logger.info("user found : "+ userDetail);

        if(userDetail.get() == null){
        }
        UserDetails detail = new ApplicationUserDetails(userDetail.get());

        logger.info("return UserDetails: "+detail);
        logger.info("return password: "+detail.getPassword());

        return detail;
    }

}
