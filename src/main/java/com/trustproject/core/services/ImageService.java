package com.trustproject.core.services;

import com.trustproject.core.model.Image;

public interface ImageService {

    Image getImageById(Long id);
    Image saveImage(Image image);
}
