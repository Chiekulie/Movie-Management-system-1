package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
    Keyword findByKeywordName(String keywordName);
}
