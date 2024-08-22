package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.LanguageDto;
import com.usl.training.movie_management_system.entity.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {
    public static Language mapToLanguage(LanguageDto languageDto) {
        if (languageDto == null) {
            return null;
        }

        Language language = new Language();

        language.setLanguageId(language.getLanguageId());
        language.setLanguageCode(languageDto.getLanguageCode());
        language.setLanguageName(languageDto.getLanguageName());
        return language;
    }

    public static LanguageDto mapToLanguageDto(Language language) {
        if (language == null) {
            return null;
        }
        LanguageDto languageDto = new LanguageDto();
        languageDto.setLanguageId(language.getLanguageId());
        languageDto.setLanguageCode(language.getLanguageCode());
        languageDto.setLanguageName(language.getLanguageName());
        return languageDto;
    }
}
