package com.spring.security.medi.care.app.commons.repository;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Parentesco implements Serializable {

    @Id
    private Long parentescoId;








}
