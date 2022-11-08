package com.spring.security.medi.care.app.file.repository;

import com.spring.security.medi.care.app.commons.domain.Attachment;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentJpaRepo extends CrudRepository<Attachment, Long> {
}
