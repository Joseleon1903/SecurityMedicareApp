package com.spring.security.medi.care.app.controller.rest;

import com.spring.security.medi.care.app.commons.domain.ImagedStored;
import com.spring.security.medi.care.app.commons.exception.InternalServerException;
import com.spring.security.medi.care.app.commons.exception.ResourceNotFoundException;
import com.spring.security.medi.care.app.file.service.FileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileRestController {

    private final FileService imageServiceImpl;

    public FileRestController(FileService imageServiceImpl) {
        this.imageServiceImpl = imageServiceImpl;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            imageServiceImpl.createImage(file);
        }catch(ResourceNotFoundException | InternalServerException ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return "successifully upload!";
    }


    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName) {

        String contentType = "application/octet-stream";
        Resource resource = imageServiceImpl.loadFileAsResource(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping(value = "/view/image/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public ResponseEntity<InputStreamResource> viewImage(@PathVariable("fileName") String fileName) throws IOException {
        Resource in = imageServiceImpl.loadFileAsResource(fileName);
        return ResponseEntity.ok()
                .contentLength(in.contentLength())
                .contentType(MediaType.parseMediaType( MediaType.IMAGE_JPEG_VALUE))
                .body(new InputStreamResource(in.getInputStream()));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ImagedStored>> getImageStored() throws IOException {
        List<ImagedStored> listout = imageServiceImpl.findAllImagedStored();
        return ResponseEntity.ok().body(listout);
    }

}
