package com.spring.security.medi.care.app.commons.domain;

import org.springframework.security.core.GrantedAuthority;

public class Rol implements GrantedAuthority {

    private String id;

    public Rol(String id) {
        this.id = id;
    }

    public Rol() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }


}
