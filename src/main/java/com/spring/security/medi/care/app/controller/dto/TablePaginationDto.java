package com.spring.security.medi.care.app.controller.dto;

import org.springframework.stereotype.Component;
import java.io.Serializable;
import lombok.Data;

@Data
@Component
public class TablePaginationDto implements Serializable{

    private int paginationIndex = 0;

    private long remainCount= 0;

    public TablePaginationDto(int paginationIndex, long remainCount) {
        this.paginationIndex = paginationIndex;
        this.remainCount = remainCount;
    }

    public TablePaginationDto() {
    }
}
