package com.trustproject.core.services;

import com.trustproject.core.model.Card;
import com.trustproject.core.model.EnWord;

public interface CardService {
    Card getCard(Long id);

    Card getCardByEnWord(EnWord enWord);

    void addCard(Card card);
}
