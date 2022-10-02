package com.spring.security.medi.care.app.commons.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jose eduardo on 3/25/2020.
 */
@Data
@Entity
public class Attachment {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "attachment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    private String fileName;

    private String fileDetail;

    private String documentType;

    private String userName;

    private Date uploadDate;

    private String downloadUri;

    private String viewUri;

    public Attachment(Long id, String fileName, String fileDetail, String documentType, String userName, Date uploadDate, String downloadUri, String viewUri) {
        this.id = id;
        this.fileName = fileName;
        this.fileDetail = fileDetail;
        this.documentType = documentType;
        this.userName = userName;
        this.uploadDate = uploadDate;
        this.downloadUri = downloadUri;
        this.viewUri = viewUri;
    }

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileDetail='" + fileDetail + '\'' +
                ", documentType='" + documentType + '\'' +
                ", userName='" + userName + '\'' +
                ", uploadDate=" + uploadDate +
                ", downloadUri='" + downloadUri + '\'' +
                ", viewUri='" + viewUri + '\'' +
                '}';
    }
}
