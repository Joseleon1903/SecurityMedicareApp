package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.htmvalidation.NotExistingUser;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Component
@Data
@NotExistingUser
public class CreateUserFormData {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String posicion;

    private String detalle;

    @NotBlank
    private Long tipoUsuarioId;

    @NotBlank
    @Email
    private String correoprimario;

    public CreateUserFormData(String username, String password, String confirmPassword, String posicion, String detalle, Long tipoUsuarioId, String correoprimario) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.posicion = posicion;
        this.detalle = detalle;
        this.tipoUsuarioId = tipoUsuarioId;
        this.correoprimario = correoprimario;
    }

    public CreateUserFormData() {
    }

    @Override
    public String toString() {
        return "CreateUserFormData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", posicion='" + posicion + '\'' +
                ", detalle='" + detalle + '\'' +
                ", tipoUsuarioId=" + tipoUsuarioId +
                ", correoprimario='" + correoprimario + '\'' +
                '}';
    }

    public void clear() {
        this.username = null;
        this.password = null;
        this.confirmPassword = null;
        this.posicion = null;
        this.detalle = null;
        this.tipoUsuarioId = null;
        this.correoprimario = null;
    }
}
