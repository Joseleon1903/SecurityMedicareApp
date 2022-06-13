package com.spring.wlg.controller.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class SystemInfoDTO implements Serializable {

    public String pageName;

    public Date sysDate;

    public SystemInfoDTO() {
    }

    public SystemInfoDTO(String pageName, Date sysDate) {
        this.pageName = pageName;
        this.sysDate = sysDate;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    @Override
    public String toString() {
        return "SistemInfoDTO{" +
                "pageName='" + pageName + '\'' +
                ", sysDate=" + sysDate +
                '}';
    }
}
