package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorPageDto implements Serializable {

    private static final long serialVersionUID = -742209968383196712L;
    private String descripcionError;

    private Long codigoError;

    private boolean isError = false;

    public ErrorPageDto(Long codigoError, String descripcionError, boolean isError) {
        this.descripcionError = descripcionError;
        this.codigoError = codigoError;
        this.isError = isError;
    }

    public ErrorPageDto() {
        isError = false;
    }

    @Override
    public String toString() {
        return "ErrorPageDto{" +
                "descripcionError='" + descripcionError + '\'' +
                ", codigoError='" + codigoError + '\'' +
                ", isError=" + isError +
                '}';
    }
}
