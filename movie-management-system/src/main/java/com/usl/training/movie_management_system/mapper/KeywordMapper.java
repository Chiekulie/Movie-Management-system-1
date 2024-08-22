package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.KeywordDto;
import com.usl.training.movie_management_system.entity.Keyword;
import org.springframework.stereotype.Component;

@Component
public class KeywordMapper {
    public static Keyword mapToKeyword(KeywordDto keywordDto) {
        if (keywordDto == null) {
            return null;
        }

        Keyword keyword = new Keyword();
        keyword.setKeywordId(keywordDto.getKeywordId());
        keyword.setKeywordName(keywordDto.getKeywordName());
        return keyword;
    }

    public static KeywordDto mapToKeywordDto(Keyword keyword) {
        if (keyword == null) {
            return null;
        }
        KeywordDto keywordDto = new KeywordDto();
        keywordDto.setKeywordId(keyword.getKeywordId());
        keywordDto.setKeywordName(keyword.getKeywordName());
        return keywordDto;
    }
}
