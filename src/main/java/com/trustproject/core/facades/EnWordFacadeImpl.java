package com.trustproject.core.facades;

import com.trustproject.core.dto.EnWordDTO;
import com.trustproject.core.mappers.EnWordMapper;
import com.trustproject.core.model.EnWord;
import com.trustproject.core.services.EnWordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnWordFacadeImpl implements EnWordFacade {
    private final EnWordService enWordService;
    private final EnWordMapper enWordMapper;

    public EnWordDTO getEnWordById(Long id) {
        EnWord enWord = enWordService.getEnWord(id);
        return enWordMapper.toDTO(enWord);
    }

    public EnWordDTO getEnWordByWord(String word) {
        EnWord enWord = enWordService.getEnWordByWord(word);
        return enWordMapper.toDTO(enWord);
    }
}
