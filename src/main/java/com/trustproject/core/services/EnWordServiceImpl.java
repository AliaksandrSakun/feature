package com.trustproject.core.services;

import com.trustproject.core.model.EnWord;
import com.trustproject.core.repository.EnWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnWordServiceImpl implements EnWordService {

    private final EnWordRepository enWordRepository;

    @Override
    public EnWord getEnWord(Long id) {
        return enWordRepository.getById(id);
    }

    @Override
    public EnWord getEnWordByWord(String word) {
        return enWordRepository.findByMeaning(word);
    }
}
