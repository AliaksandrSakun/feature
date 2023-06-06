package com.trustproject.core.controllers;

import com.trustproject.core.dto.CardDTO;
import com.trustproject.core.facades.CardFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardFacade cardFacade;

    @GetMapping("/cards/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Long id) {
        return cardFacade.getCardById(id);
    }

    @GetMapping("/translate/{enWord}")
    public ResponseEntity<?> getCardByEnWord(@PathVariable String enWord) {
        return cardFacade.getCardByWord(enWord);
    }

    @PostMapping("/cards")
    public ResponseEntity<?> saveCard(@RequestBody CardDTO cardDTO) {
        return cardFacade.saveCard(cardDTO);
    }
}
