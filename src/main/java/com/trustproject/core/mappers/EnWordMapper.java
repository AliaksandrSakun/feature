package com.trustproject.core.mappers;

import com.trustproject.core.dto.EnWordDTO;
import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.model.EnWord;
import com.trustproject.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnWordMapper {
    EnWordDTO toDTO(EnWord enWord);
}
