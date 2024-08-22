package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.LanguageDto;
import com.usl.training.movie_management_system.entity.Language;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.LanguageMapper;
import com.usl.training.movie_management_system.repository.LanguageRepository;
import com.usl.training.movie_management_system.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepository languageRepository;

    @Override
    public List<LanguageDto> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();
        return languages.stream().map(LanguageMapper::mapToLanguageDto).collect(Collectors.toList());
    }

    @Override
    public LanguageDto getLanguageById(Integer languageId) {
        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + languageId));
        return LanguageMapper.mapToLanguageDto(language);
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {
        Language language = LanguageMapper.mapToLanguage(languageDto);
        if (language.getLanguageCode().length() != 2) {
            throw new IllegalArgumentException("ISO code must be exactly 2 characters long");
        }
        return LanguageMapper.mapToLanguageDto(languageRepository.save(language));
    }

    @Override
    public LanguageDto updateLanguage(Integer languageId, LanguageDto languageDto) {
        if (languageDto.getLanguageCode().length() != 2) {
            throw new IllegalArgumentException("ISO code must be exactly 2 characters long");
        }
        Language language = languageRepository.findById(languageId)
                .map(existingLanguage -> {
                    BeanUtils.copyProperties(languageDto, existingLanguage, "languageId");
                    return languageRepository.save(existingLanguage);
                }).orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + languageId));
        return LanguageMapper.mapToLanguageDto(language);
    }

    @Override
    public void deleteLanguage(Integer languageId) {
        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + languageId));
        languageRepository.delete(language);
    }
}
