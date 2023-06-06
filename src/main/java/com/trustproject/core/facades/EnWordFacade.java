package com.trustproject.core.facades;

import com.trustproject.core.dto.EnWordDTO;

public interface EnWordFacade {
    EnWordDTO getEnWordById(Long id);
    EnWordDTO getEnWordByWord(String word);
}
