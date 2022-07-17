package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class ErrorPageDto implements Serializable {

    private String descripcionError;

    private String codigoError;

    private boolean isError;

    public ErrorPageDto(String descripcionError, String codigoError, boolean isError) {
        this.descripcionError = descripcionError;
        this.codigoError = codigoError;
        this.isError = isError;
    }

    public ErrorPageDto() {}

    @Override
    public String toString() {
        return "ErrorPageDto{" +
                "descripcionError='" + descripcionError + '\'' +
                ", codigoError='" + codigoError + '\'' +
                ", isError=" + isError +
                '}';
    }
}
