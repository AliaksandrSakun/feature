package com.trustproject.core.controllers;

import com.trustproject.core.facades.ImageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageFacade imageFacade;

    @GetMapping("/images/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        return imageFacade.getImage(id);
    }

    @PostMapping("/images")
    public ResponseEntity<?> saveImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageFacade.saveImage(file);
    }
}
