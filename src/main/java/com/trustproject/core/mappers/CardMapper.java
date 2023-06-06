package com.trustproject.core.mappers;

import com.trustproject.core.dto.CardDTO;
import com.trustproject.core.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CardMapper {
    @Mapping(target = "enWord", source = "enWord")
    @Mapping(target = "ruWord", source = "ruWord")
    CardDTO toDTO(Card card);
    Card toEntity(CardDTO cardDTO);
}
