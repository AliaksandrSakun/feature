package com.trustproject.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private EnWordDTO enWord;
    private RuWordDTO ruWord;
    private ImageDTO image;
    private Long rating;
}
