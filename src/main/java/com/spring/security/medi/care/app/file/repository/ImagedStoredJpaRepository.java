package com.spring.security.medi.care.app.file.repository;

import com.spring.security.medi.care.app.commons.domain.ImagedStored;
import org.springframework.data.repository.CrudRepository;

public interface ImagedStoredJpaRepository extends CrudRepository<ImagedStored, Long> {

    ImagedStored findByName(String name);
}
