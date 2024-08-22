package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.LanguageDto;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getAllLanguages();
    LanguageDto getLanguageById(Integer languageId);
    LanguageDto createLanguage(LanguageDto languageDto);
    LanguageDto updateLanguage(Integer languageId, LanguageDto languageDto);
    void deleteLanguage(Integer languageId);
}
