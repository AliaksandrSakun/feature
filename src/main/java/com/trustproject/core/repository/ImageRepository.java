package com.trustproject.core.repository;

import com.trustproject.core.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
    Image getImageById(Long id);
}
