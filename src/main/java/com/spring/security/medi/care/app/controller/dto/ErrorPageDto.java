package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class ErrorPageDto implements Serializable {

    private String descripcionError;

    private Integer codigoError;

    private boolean isError = false;

    public ErrorPageDto(Integer codigoError,String descripcionError, boolean isError) {
        this.descripcionError = descripcionError;
        this.codigoError = codigoError;
        this.isError = isError;
    }

    public ErrorPageDto() {
        isError =false;
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
