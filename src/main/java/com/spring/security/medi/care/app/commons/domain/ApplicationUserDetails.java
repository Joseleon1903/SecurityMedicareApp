package com.spring.security.medi.care.app.commons.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class ApplicationUserDetails implements UserDetails {

    private final Long id;
    private final String username;
    private final String displayName;
    private final String password;
    private final Set<GrantedAuthority> authorities;


    public ApplicationUserDetails(Usuario user) {
        this.id = user.getUsuarioId();
        this.username = user.getCodigo();
        this.displayName = user.getContactoId().getCorreoPrimario();
        this.password = user.getLlaveEncriptacion();
        this.authorities = new HashSet<>();
        this.authorities.add(new Rol(user.getTipoUsuarioId().getDescripcion()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean hasUserRole(String rolname){

        for (GrantedAuthority rol: getAuthorities()) {

            if(rol.getAuthority().equals(rolname)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ApplicationUserDetails{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
