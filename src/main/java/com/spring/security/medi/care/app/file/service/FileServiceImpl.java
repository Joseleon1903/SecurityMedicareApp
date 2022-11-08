package com.spring.security.medi.care.app.file.service;

import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionServiceImpl;
import com.spring.security.medi.care.app.commons.domain.Attachment;
import com.spring.security.medi.care.app.commons.domain.ImagedStored;
import com.spring.security.medi.care.app.commons.exception.InternalServerException;
import com.spring.security.medi.care.app.commons.exception.ResourceNotFoundException;
import com.spring.security.medi.care.app.file.repository.AttachmentJpaRepo;
import com.spring.security.medi.care.app.file.repository.ImagedStoredJpaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    private static final Logger logger = LoggerFactory.getLogger(SolicitudAfiliacionServiceImpl.class);

    private final Path fileStorageLocation;

    private final ResourceLoader resourceLoader;

    private final ImagedStoredJpaRepo imagesDataRepository;

    private final AttachmentJpaRepo attachmentRepository;


    @Autowired
    public FileServiceImpl(ResourceLoader resourceLoader, ImagedStoredJpaRepo imagesDataRepository, AttachmentJpaRepo attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.resourceLoader = resourceLoader;
        this.imagesDataRepository = imagesDataRepository;
        this.fileStorageLocation = Paths.get("./uploads")
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
//            throw new Exception("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public ImagedStored createImage(MultipartFile file) throws ResourceNotFoundException, InternalServerException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImagedStored entity =imagesDataRepository.findByName(fileName).orElseThrow( ()-> new ResourceNotFoundException("not found file "));

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            if(entity ==null){
                entity= new ImagedStored();
                entity.setCreationDate(LocalDateTime.now());
            }

            entity.setName(fileName);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/downloadFile/")
                    .path(fileName)
                    .toUriString();

            String fileViewUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/view/image/")
                    .path(fileName)
                    .toUriString();

            entity.setFileDownloadUri(fileDownloadUri);
            entity.setFileViewUri(fileViewUri);
            entity.setFileType(file.getContentType());
            entity.setSize(file.getSize());
            entity.setUpdateDate(LocalDateTime.now());
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            imagesDataRepository.save(entity);
        } catch (IOException ex) {
            throw new InternalServerException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return entity;
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        Resource resource = resourceLoader.getResource(filePath.toUri().toString());
        if (resource.exists()) {
            return resource;
        } else {
            logger.error("File not found " + fileName);
        }
        return null;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file, String username) throws IOException {

        Attachment attachment = new Attachment();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        attachment.setFileName(fileName);
        attachment.setUserName(username);
        attachment.setUploadDate(LocalDateTime.now());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/downloadFile/")
                    .path(fileName)
                    .toUriString();
            attachment.setDownloadUri(fileDownloadUri);

            String fileViewUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/view/image/")
                    .path(fileName)
                    .toUriString();
            attachment.setViewUri(fileViewUri);

            String extension = file.getOriginalFilename().split("\\.")[1];
            String contentType = file.getContentType();
            attachment.setDocumentType(contentType+"-"+extension);

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            attachment.setFileDetail("targetlocation:"+targetLocation.getRoot().toString());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return attachmentRepository.save(attachment);
    }

    @Override
    public ImagedStored findById(long id){
        return imagesDataRepository.findById(id).get();
    }

    @Override
    public List<ImagedStored> findAllImagedStored() {
        List<ImagedStored> imagelist =  new ArrayList<>();
        imagesDataRepository.findAll().forEach( img ->{
            imagelist.add(img);
        });
        return imagelist;
    }

}
