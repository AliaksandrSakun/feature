package com.trustproject.core.controllers;

import com.trustproject.core.dto.EnWordDTO;
import com.trustproject.core.facades.EnWordFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnWordController {

    private final EnWordFacade enWordFacade;

    @GetMapping("/en-words/{id}")
    public EnWordDTO getEnWordById(@PathVariable Long id) {
        return enWordFacade.getEnWordById(id);
    }

    @GetMapping("/words/{word}")
    public EnWordDTO getEnWordByWord(@PathVariable String word) {
        return enWordFacade.getEnWordByWord(word);
    }
}
