package com.spring.security.medi.care.app.commons;

import lombok.Data;

@Data
public class PaginationOutput {

    private Integer pageIndex;
    private Integer rowSize;
    private Long totalRowCount;
    private Integer totalPages;

    public PaginationOutput(Integer pageIndex, Integer rowSize) {
        this.pageIndex = pageIndex;
        this.rowSize = rowSize;
    }

    public PaginationOutput(Integer pageIndex, Integer rowSize, Long totalRowCount, Integer totalPages) {
        this.pageIndex = pageIndex;
        this.rowSize = rowSize;
        this.totalRowCount = totalRowCount;
        this.totalPages = totalPages;
    }

    public PaginationOutput() {
    }

    @Override
    public String toString() {
        return "PaginationOutput{" +
                "pageIndex=" + pageIndex +
                ", rowSize=" + rowSize +
                ", totalRowCount=" + totalRowCount +
                ", totalPages=" + totalPages +
                '}';
    }
}
