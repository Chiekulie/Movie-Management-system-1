package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.KeywordDto;
import com.usl.training.movie_management_system.entity.Keyword;
import com.usl.training.movie_management_system.entity.Movie;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.KeywordMapper;
import com.usl.training.movie_management_system.repository.KeywordRepository;
import com.usl.training.movie_management_system.service.KeywordService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KeywordServiceImpl implements KeywordService {

    private KeywordRepository keywordRepository;

    @Override
    public List<KeywordDto> getAllKeywords() {
        List<Keyword> keywords = keywordRepository.findAll();
        return keywords.stream().map(KeywordMapper::mapToKeywordDto).collect(Collectors.toList());
    }

    @Override
    public KeywordDto getKeywordById(Integer id) {
        Keyword keyword = keywordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyword not found with id " + id));
        return KeywordMapper.mapToKeywordDto(keyword);
    }

    @Override
    public KeywordDto createKeyword(KeywordDto keywordDto) {
        Keyword keyword = KeywordMapper.mapToKeyword(keywordDto);
        return KeywordMapper.mapToKeywordDto(keywordRepository.save(keyword));
    }

    @Override
    public KeywordDto updateKeyword(Integer keywordId, KeywordDto keywordDto) {
        Keyword keyword = keywordRepository.findById(keywordId)
                .map(existingKeyword -> {
                    BeanUtils.copyProperties(keywordDto, existingKeyword, "keywordId");
                    return keywordRepository.save(existingKeyword);
                }).orElseThrow(() -> new ResourceNotFoundException("Keyword not found with id " + keywordId));
        return KeywordMapper.mapToKeywordDto(keyword);
    }

    @Override
    public void deleteKeyword(Integer id) {
        Keyword keyword = keywordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyword not found with id " + id));
        keywordRepository.delete(keyword);
    }
}
