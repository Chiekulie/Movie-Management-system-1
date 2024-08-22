package com.usl.training.movie_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class LanguageDto {
    private Integer languageId;
    private String languageCode;
    private String languageName;
}
