package com.trustproject.core.mappers;

import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);
}
