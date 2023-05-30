package com.trustproject.core.controllers;

import com.trustproject.core.dto.EnWordDTO;
import com.trustproject.core.dto.UserDTO;
import com.trustproject.core.mappers.EnWordMapper;
import com.trustproject.core.mappers.UserMapper;
import com.trustproject.core.model.EnWord;
import com.trustproject.core.model.User;
import com.trustproject.core.services.EnWordService;
import com.trustproject.core.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnWordController {

    private final EnWordService enWordService;
    private final EnWordMapper enWordMapper;

    @GetMapping("/en-words/{id}")
    public EnWordDTO getUserById(@PathVariable Long id) {
        EnWord enWord = enWordService.getEnWord(id);
        return enWordMapper.toDTO(enWord);
    }
}
