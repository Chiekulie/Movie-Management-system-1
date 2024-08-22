package com.usl.training.movie_management_system.service.impl;


import com.usl.training.movie_management_system.dto.MovieCastDto;
import com.usl.training.movie_management_system.dto.MovieDto;
import com.usl.training.movie_management_system.entity.Movie;
import com.usl.training.movie_management_system.entity.MovieCast;
import com.usl.training.movie_management_system.entity.MovieCastId;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.MovieCastMapper;
import com.usl.training.movie_management_system.repository.MovieCastRepository;
import com.usl.training.movie_management_system.repository.MovieRepository;
import com.usl.training.movie_management_system.repository.PersonRepository;
import com.usl.training.movie_management_system.service.MovieCastService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MovieCastServiceImpl implements MovieCastService {
    private final MovieCastRepository movieCastRepository;


    public List<MovieCastDto> getAllMovieCasts() {
        List<MovieCast> movieCasts = movieCastRepository.findAll();

        return movieCasts.stream().map(MovieCastMapper::mapToMovieCastDto).collect(Collectors.toList());
    }

    public List<MovieCastDto> getMovieCastsByMovieTitle(String title) {
        List<MovieCast> movieCast = movieCastRepository.findByMovieTitle(title);
        return movieCast.stream().map(MovieCastMapper::mapToMovieCastDto).collect(Collectors.toList());
    }


}



