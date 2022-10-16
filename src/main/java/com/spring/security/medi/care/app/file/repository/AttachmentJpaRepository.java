package com.spring.security.medi.care.app.file.repository;

import com.spring.security.medi.care.app.commons.domain.Attachment;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentJpaRepository extends CrudRepository<Attachment, Long> {
}
