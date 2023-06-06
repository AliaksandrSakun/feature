package com.trustproject.core.facades;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageFacade {
    ResponseEntity<?> getImage(Long id);
    ResponseEntity<?> saveImage(MultipartFile file) throws IOException;
}
