package com.trustproject.core.mappers;

import com.trustproject.core.dto.EnWordDTO;
import com.trustproject.core.model.EnWord;
import org.mapstruct.Mapper;

@Mapper
public interface EnWordMapper {
    EnWordDTO toDTO(EnWord enWord);
}
