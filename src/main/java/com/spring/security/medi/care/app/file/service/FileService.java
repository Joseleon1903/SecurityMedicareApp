package com.spring.security.medi.care.app.file.service;

import com.spring.security.medi.care.app.commons.domain.Attachment;
import com.spring.security.medi.care.app.commons.domain.ImagedStored;
import com.spring.security.medi.care.app.commons.exception.InternalServerException;
import com.spring.security.medi.care.app.commons.exception.ResourceAlreadyExistException;
import com.spring.security.medi.care.app.commons.exception.ResourceNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface FileService {

    ImagedStored createImage(MultipartFile file) throws ResourceAlreadyExistException, InternalServerException;

    ImagedStored findById(long id);

    List<ImagedStored> findAllImagedStored();

    Resource loadFileAsResource(String fileName);

    Attachment saveAttachment(MultipartFile file, String userName) throws IOException;
}
