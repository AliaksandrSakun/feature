package com.trustproject.core.controllers;

import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.mappers.UserMapper;
import com.trustproject.core.model.User;
import com.trustproject.core.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        return UserMapper.INSTANCE.toDTO(user);
    }
}
