package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long usuarioId;
    private String codigo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="contactoId")
    private Contacto contactoId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tipoUsuarioId")
    private TipoUsuario tipoUsuarioId;

    private String llaveEncriptacion;
    private Date fechaUltimoCambio;
    private String estado;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String codigo, Contacto contactoId, String llaveEncriptacion, Date fechaUltimoCambio, String estado) {
        this.usuarioId = usuarioId;
        this.codigo = codigo;
        this.contactoId = contactoId;
        this.llaveEncriptacion = llaveEncriptacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", codigo='" + codigo + '\'' +
                ", contactoId=" + contactoId +
                ", tipoUsuarioId=" + tipoUsuarioId +
                ", llaveEncriptacion='" + llaveEncriptacion + '\'' +
                ", fechaUltimoCambio=" + fechaUltimoCambio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
