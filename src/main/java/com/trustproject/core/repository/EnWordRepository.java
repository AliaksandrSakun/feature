package com.trustproject.core.repository;

import com.trustproject.core.model.EnWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnWordRepository extends CrudRepository<EnWord, Long> {
    EnWord getById(Long id);
    EnWord findByMeaning(String word);
}
