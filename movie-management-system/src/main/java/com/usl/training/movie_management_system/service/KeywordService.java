package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.KeywordDto;

import java.util.List;

public interface KeywordService {
    List<KeywordDto> getAllKeywords();
    KeywordDto getKeywordById(Integer id);
    KeywordDto createKeyword(KeywordDto keywordDto);
    KeywordDto updateKeyword(Integer keywordId, KeywordDto keywordDto);
    void deleteKeyword(Integer id);

}
