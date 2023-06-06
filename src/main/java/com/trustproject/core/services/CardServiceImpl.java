package com.trustproject.core.services;

import com.trustproject.core.model.Card;
import com.trustproject.core.model.EnWord;
import com.trustproject.core.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card getCard(Long id) {
        return cardRepository.getById(id);
    }

    @Override
    public Card getCardByEnWord(EnWord enWord) {
        return cardRepository.findCardByEnWord(enWord);
    }

    @Override
    public void addCard(Card card) {
        cardRepository.save(card);
    }
}
