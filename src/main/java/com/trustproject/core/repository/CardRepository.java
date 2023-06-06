package com.trustproject.core.repository;

import com.trustproject.core.model.Card;
import com.trustproject.core.model.EnWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    Card getById(Long id);

    Card findCardByEnWord(EnWord enWord);

    @Override
    default <S extends Card> S save(S entity) {
        return null;
    }
}
