package com.trustproject.core.facades;

import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.mappers.UserMapper;
import com.trustproject.core.model.User;
import com.trustproject.core.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        return userMapper.toDTO(user);
    }
}
