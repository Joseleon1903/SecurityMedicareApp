package com.spring.security.medi.care.app.controller.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class EntidadFilterDTO implements Serializable {


    private static final long serialVersionUID = 3923042551200298956L;
    private String seguroId;
    private String regimenId;
    private String texto;
    private int rowCounter;

    public EntidadFilterDTO(String seguroId, String regimenId, String texto, int rowCounter) {
        this.seguroId = seguroId;
        this.regimenId = regimenId;
        this.texto = texto;
        this.rowCounter = rowCounter;
    }

    public EntidadFilterDTO() {
    }

    public String getSeguroId() {
        return seguroId;
    }

    public void setSeguroId(String seguroId) {
        this.seguroId = seguroId;
    }

    public String getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(String regimenId) {
        this.regimenId = regimenId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(int rowCounter) {
        this.rowCounter = rowCounter;
    }

    @Override
    public String toString() {
        return "EntidadFilterDTO{" +
                "seguroId=" + seguroId +
                ", regimenId=" + regimenId +
                ", texto='" + texto + '\'' +
                ", rowCounter=" + rowCounter +
                '}';
    }
}
