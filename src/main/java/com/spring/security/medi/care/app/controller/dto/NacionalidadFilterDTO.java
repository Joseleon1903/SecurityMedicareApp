package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class NacionalidadFilterDTO implements Serializable {

    private static final long serialVersionUID = -4108035206230330792L;
    private String paisId;
    private int rowCounter = DaoUtil.DEFAULT_ROW_COUNT;
    private int page = DaoUtil.DEFAULT_PAGE;

    public NacionalidadFilterDTO(String paisId) {
        this.paisId = paisId;
    }

    public NacionalidadFilterDTO() {
    }

    @Override
    public String toString() {
        return "NacionalidadFilterDTO{" +
                "paisId='" + paisId + '\'' +
                ", rowCounter=" + rowCounter +
                ", page=" + page +
                '}';
    }
}
