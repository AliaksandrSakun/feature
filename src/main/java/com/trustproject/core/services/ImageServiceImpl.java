package com.trustproject.core.services;

import com.trustproject.core.model.Image;
import com.trustproject.core.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.getImageById(id);
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
}
