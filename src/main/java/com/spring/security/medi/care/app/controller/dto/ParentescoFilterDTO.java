package com.spring.security.medi.care.app.controller.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class ParentescoFilterDTO implements Serializable {

    private String tipoDependiente;
    private String genero;
    private String rowCounter;

    public ParentescoFilterDTO(String tipoDependiente, String genero) {
        this.tipoDependiente = tipoDependiente;
        this.genero = genero;
    }

    public ParentescoFilterDTO(String tipoDependiente, String genero, String rowCounter) {
        this.tipoDependiente = tipoDependiente;
        this.genero = genero;
        this.rowCounter = rowCounter;
    }

    public ParentescoFilterDTO() {
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

    public String getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(String rowCounter) {
        this.rowCounter = rowCounter;
    }

    @Override
    public String toString() {
        return "ParentescoFilterDTO{" +
                "tipoDependiente='" + tipoDependiente + '\'' +
                ", genero='" + genero + '\'' +
                ", rowCounter='" + rowCounter + '\'' +
                '}';
    }
}