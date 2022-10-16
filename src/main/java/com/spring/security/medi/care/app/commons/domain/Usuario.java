package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long usuarioId;
    private String codigo;

    private String profilePicture;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="contactoId")
    private Contacto contactoId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tipoUsuarioId")
    private TipoUsuario tipoUsuarioId;

    private String llaveEncriptacion;
    private LocalDateTime fechaUltimoCambio;
    private String estado;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String codigo, String profilePicture, Contacto contactoId, TipoUsuario tipoUsuarioId, String llaveEncriptacion, LocalDateTime fechaUltimoCambio, String estado) {
        this.usuarioId = usuarioId;
        this.codigo = codigo;
        this.profilePicture = profilePicture;
        this.contactoId = contactoId;
        this.tipoUsuarioId = tipoUsuarioId;
        this.llaveEncriptacion = llaveEncriptacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", codigo='" + codigo + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", contactoId=" + contactoId +
                ", tipoUsuarioId=" + tipoUsuarioId +
                ", llaveEncriptacion='" + llaveEncriptacion + '\'' +
                ", fechaUltimoCambio=" + fechaUltimoCambio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
