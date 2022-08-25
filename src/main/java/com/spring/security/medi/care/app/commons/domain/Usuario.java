package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long usuarioId;
    private String codigo;

    @OneToOne
    @JoinColumn(name="contactoId")
    private Contacto contactoId;
    private Long tipousuarioId;
    private String llaveEncriptacion;
    private LocalDate fechaUltimoCambio;
    private String estado;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String codigo, Contacto contactoId, Long tipousuarioId, String llaveEncriptacion, LocalDate fechaUltimoCambio, String estado) {
        this.usuarioId = usuarioId;
        this.codigo = codigo;
        this.contactoId = contactoId;
        this.tipousuarioId = tipousuarioId;
        this.llaveEncriptacion = llaveEncriptacion;
        this.fechaUltimoCambio = fechaUltimoCambio;
        this.estado = estado;
    }
}
