package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.DaoUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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
