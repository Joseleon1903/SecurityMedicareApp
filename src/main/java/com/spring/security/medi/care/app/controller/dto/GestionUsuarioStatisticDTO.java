package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GestionUsuarioStatisticDTO implements Serializable {


    private static final long serialVersionUID = 3092540121138736429L;

    private Long totalUserCount;
    private Long activeUserCount;
    private Long inactiveUserCount;

    public GestionUsuarioStatisticDTO() {
    }

    public GestionUsuarioStatisticDTO(Long totalUserCount, Long activeUserCount, Long inactiveUserCount) {
        this.totalUserCount = totalUserCount;
        this.activeUserCount = activeUserCount;
        this.inactiveUserCount = inactiveUserCount;
    }

    @Override
    public String toString() {
        return "GestionUsuarioStatisticDTO{" +
                "totalUserCount=" + totalUserCount +
                ", activeUserCount=" + activeUserCount +
                ", inactiveUserCount=" + inactiveUserCount +
                '}';
    }
}
