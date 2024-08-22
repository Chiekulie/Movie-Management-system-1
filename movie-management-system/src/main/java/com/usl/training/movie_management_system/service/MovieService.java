package com.usl.training.movie_management_system.service;


import com.usl.training.movie_management_system.dto.MovieDto;

import java.util.List;

public interface MovieService {
    MovieDto getMovieById(Integer movieId);
    List<MovieDto> getAllMovies();
    MovieDto getMovieByTitle(String title);
    MovieDto createMovie(MovieDto movieDto);
    MovieDto updateMovie(Integer movieId, MovieDto movieDto);
    void deleteMovie(Integer movieId);
    List<MovieDto> getMoviesByActorName(String actorName);
}
