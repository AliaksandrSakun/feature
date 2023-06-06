package com.trustproject.core.services;

import com.trustproject.core.model.EnWord;


public interface EnWordService {
    EnWord getEnWord(Long id);
    EnWord getEnWordByWord(String word);
}
