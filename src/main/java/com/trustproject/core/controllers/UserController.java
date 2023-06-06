package com.trustproject.core.controllers;

import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userFacade.getUserById(id);
    }
}
