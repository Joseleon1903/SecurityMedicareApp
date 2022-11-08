package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class SystemInfoDTO implements Serializable {

    private static final long serialVersionUID = 7947773125506486793L;
    private String pageName;

    private String descripcion;

    private LocalDate sysDate;

    public SystemInfoDTO() {
    }

    public SystemInfoDTO(String pageName, LocalDate sysDate) {
        this.pageName = pageName;
        this.sysDate = sysDate;
        this.descripcion = "";
    }

    public SystemInfoDTO(String pageName, String descripcion, LocalDate sysDate) {
        this.pageName = pageName;
        this.descripcion = descripcion;
        this.sysDate = sysDate;
    }

    @Override
    public String toString() {
        return "SystemInfoDTO{" +
                "pageName='" + pageName + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", sysDate=" + sysDate +
                '}';
    }
}
