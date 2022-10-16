package com.spring.security.medi.care.app.controller.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class SystemInfoDTO implements Serializable {

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public LocalDate getSysDate() {
        return sysDate;
    }

    public void setSysDate(LocalDate sysDate) {
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
