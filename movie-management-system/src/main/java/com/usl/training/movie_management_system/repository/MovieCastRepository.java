package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.dto.MovieCastDto;
import com.usl.training.movie_management_system.dto.MovieDto;
import com.usl.training.movie_management_system.entity.MovieCast;
import com.usl.training.movie_management_system.entity.MovieCastId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieCastRepository extends JpaRepository<MovieCast, Integer> {
    @Query("SELECT mc, p.actorName FROM MovieCast mc JOIN mc.movie m JOIN FETCH mc.person p WHERE m.title = :title")
    List<MovieCast> findByMovieTitle(@Param("title") String title);

}

