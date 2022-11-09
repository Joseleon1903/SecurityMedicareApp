package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class ImagedStored implements Serializable {

    private static final long serialVersionUID = 8967144121761988622L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String fileDownloadUri;
    private String fileViewUri;
    private String fileType;
    private long size;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public ImagedStored(String name, String fileDownloadUri, String fileViewUri, String fileType, long size) {
        this.name = name;
        this.fileDownloadUri = fileDownloadUri;
        this.fileViewUri = fileViewUri;
        this.fileType = fileType;
        this.size = size;
    }

    public ImagedStored(){}

    @Override
    public String toString() {
        return "ImagedStored{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fileDownloadUri='" + fileDownloadUri + '\'' +
                ", fileViewUri='" + fileViewUri + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}