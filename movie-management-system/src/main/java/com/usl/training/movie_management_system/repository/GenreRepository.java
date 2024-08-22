package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{
}
