package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Date creationDate;
    private Date updateDate;

    public ImagedStored(String name, String fileDownloadUri, String fileViewUri, String fileType, long size) {
        this.name = name;
        this.fileDownloadUri = fileDownloadUri;
        this.fileViewUri = fileViewUri;
        this.fileType = fileType;
        this.size = size;
    }

    public ImagedStored(String name){
        this.name = name;
    }

    public ImagedStored(){}

}