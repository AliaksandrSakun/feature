package com.trustproject.core.mappers;

import com.trustproject.core.dto.ImageDTO;
import com.trustproject.core.model.Image;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper
public interface ImageMapper {

    ImageDTO toDTO(Image image) throws IOException;

    Image toEntity(MultipartFile file) throws IOException;
}
