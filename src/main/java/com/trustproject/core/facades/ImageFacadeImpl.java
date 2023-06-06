package com.trustproject.core.facades;

import com.trustproject.core.mappers.ImageMapper;
import com.trustproject.core.model.Image;
import com.trustproject.core.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@AllArgsConstructor
public class ImageFacadeImpl implements ImageFacade{
    private final ImageMapper imageMapper;
    private final ImageService imageService;

    public ResponseEntity<?> getImage(Long id) {
        Image image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .header("filename", image.getOriginalFilename())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(image.getBytes());
    }

    public ResponseEntity<?> saveImage(MultipartFile file) throws IOException {
        Image image = imageMapper.toEntity(file);
        image = imageService.saveImage(image);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("filename", image.getOriginalFilename())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(image.getBytes());
    }
}
