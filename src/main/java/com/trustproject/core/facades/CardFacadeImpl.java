package com.trustproject.core.facades;

import com.trustproject.core.dto.CardDTO;
import com.trustproject.core.mappers.CardMapper;
import com.trustproject.core.model.Card;
import com.trustproject.core.model.EnWord;
import com.trustproject.core.services.CardService;
import com.trustproject.core.services.EnWordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CardFacadeImpl implements CardFacade{

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final EnWordService enWordService;

    public ResponseEntity<?> getCardById(Long id) {
        Card card = cardService.getCard(id);
        CardDTO cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> getCardByWord(String word) {
        EnWord enWord = enWordService.getEnWordByWord(word);
        Card card = cardService.getCardByEnWord(enWord);
        CardDTO cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> saveCard(CardDTO cardDTO) {
        Card card = cardMapper.toEntity(cardDTO);
        cardService.addCard(card);
        cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.CREATED);
    }
}
