package com.spring.security.medi.care.app.file.repository;

import com.spring.security.medi.care.app.commons.domain.ImagedStored;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImagedStoredJpaRepo extends CrudRepository<ImagedStored, Long> {

    Optional<ImagedStored> findByName(String name);
}
