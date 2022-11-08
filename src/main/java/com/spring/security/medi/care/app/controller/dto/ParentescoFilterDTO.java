package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParentescoFilterDTO implements Serializable {

    private static final long serialVersionUID = -5618315096569578958L;
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

    @Override
    public String toString() {
        return "ParentescoFilterDTO{" +
                "tipoDependiente='" + tipoDependiente + '\'' +
                ", genero='" + genero + '\'' +
                ", rowCounter='" + rowCounter + '\'' +
                '}';
    }
}