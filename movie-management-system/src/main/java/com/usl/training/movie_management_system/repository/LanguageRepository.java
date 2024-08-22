package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
