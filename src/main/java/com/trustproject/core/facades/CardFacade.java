package com.trustproject.core.facades;

import com.trustproject.core.dto.CardDTO;
import org.springframework.http.ResponseEntity;

public interface CardFacade {
    ResponseEntity<?> getCardById(Long id);
    ResponseEntity<?> getCardByWord(String word);
    ResponseEntity<?> saveCard(CardDTO cardDTO);
}
