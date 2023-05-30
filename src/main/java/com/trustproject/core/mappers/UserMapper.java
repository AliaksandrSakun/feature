package com.trustproject.core.mappers;

import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDTO(User user);
}
