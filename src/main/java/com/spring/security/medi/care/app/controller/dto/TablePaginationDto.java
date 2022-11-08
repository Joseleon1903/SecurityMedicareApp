package com.spring.security.medi.care.app.controller.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class TablePaginationDto implements Serializable{

    private static final long serialVersionUID = -780035502660559259L;
    private int paginationIndex = 0;

    private long remainCount= 0;

    public TablePaginationDto(int paginationIndex, long remainCount) {
        this.paginationIndex = paginationIndex;
        this.remainCount = remainCount;
    }

    public TablePaginationDto() {
    }

    public void setRemainCount(long remainCount) {
        if(remainCount < 0L || remainCount == 1L ){
            this.remainCount = 0;
        }else {
            this.remainCount = remainCount;
        }
    }

}
