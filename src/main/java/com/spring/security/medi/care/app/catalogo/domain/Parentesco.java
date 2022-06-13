package com.spring.security.medi.care.app.catalogo.domain;

import java.io.Serializable;

public class Parentesco implements Serializable {

    private Long parentescoId;
    private String descripcionParentesco;
    private String tipoDependiente;
    private String genero;
    private String gradoConsanguinidad;
    private String estado;

    public Parentesco(Long parentescoId, String descripcionParentesco, String tipoDependiente, String genereo, String gradoConsanguinidad, String estado) {
        this.parentescoId = parentescoId;
        this.descripcionParentesco = descripcionParentesco;
        this.tipoDependiente = tipoDependiente;
        this.genero = genereo;
        this.gradoConsanguinidad = gradoConsanguinidad;
        this.estado = estado;
    }


    public Parentesco() {}

    public Long getParentescoId() {
        return parentescoId;
    }

    public void setParentescoId(Long parentescoId) {
        this.parentescoId = parentescoId;
    }

    public String getDescripcionParentesco() {
        return descripcionParentesco;
    }

    public void setDescripcionParentesco(String descripcionParentesco) {
        this.descripcionParentesco = descripcionParentesco;
    }

    public String getTipoDependiente() {
        return tipoDependiente;
    }

    public void setTipoDependiente(String tipoDependiente) {
        this.tipoDependiente = tipoDependiente;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGradoConsanguinidad() {
        return gradoConsanguinidad;
    }

    public void setGradoConsanguinidad(String gradoConsanguinidad) {
        this.gradoConsanguinidad = gradoConsanguinidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Parentesco{" +
                "parentescoId=" + parentescoId +
                ", descripcionParentesco='" + descripcionParentesco + '\'' +
                ", tipoDependiente='" + tipoDependiente + '\'' +
                ", genero='" + genero + '\'' +
                ", gradoConsanguinidad='" + gradoConsanguinidad + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
