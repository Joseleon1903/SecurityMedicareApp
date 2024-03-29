package com.spring.security.medi.care.app.config;

import com.spring.security.medi.care.app.usuario.service.UserAuthenticationSuccessHandler;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    private final UsuarioService usuarioService;

    public WebSecurityConfiguration(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, UsuarioService usuarioService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception {
        http.authorizeRequests()
                .antMatchers("/img/*", "/assets/**",  "/css/**","/img/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/formulario/usuario").permitAll()
                .antMatchers("/create/usuario").permitAll()
                .antMatchers("/upload/picture").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll().successHandler(new UserAuthenticationSuccessHandler(usuarioService))
                .and()
                .logout()
                .logoutUrl("/logout");
    }

}