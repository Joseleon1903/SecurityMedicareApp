package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NacionalidadFilterDTO implements Serializable {

    private String paisId;
    private int rowCounter = DaoUtil.DEFAULT_ROW_COUNT;

    public NacionalidadFilterDTO(String paisId) {
        this.paisId = paisId;
    }

    public NacionalidadFilterDTO() {
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }


    public int getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(int rowCounter) {
        this.rowCounter = rowCounter;
    }

    @Override
    public String toString() {
        return "NacionalidadFilterDTO{" +
                "paisId='" + paisId + '\'' +
                ", rowCounter=" + rowCounter +
                '}';
    }
}
