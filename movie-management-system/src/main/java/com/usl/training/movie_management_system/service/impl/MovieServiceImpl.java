package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.MovieDto;
import com.usl.training.movie_management_system.entity.Movie;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.MovieMapper;
import com.usl.training.movie_management_system.repository.MovieRepository;
import com.usl.training.movie_management_system.service.MovieService;
import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;



    @Override
    public MovieDto getMovieById(Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found by id:" + movieId));
        return MovieMapper.maptoMovieDto(movie);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(MovieMapper::maptoMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieByTitle(String title) {
       Movie movie = movieRepository.findByTitle(title);
       return MovieMapper.maptoMovieDto(movie);
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = MovieMapper.maptoMovie(movieDto);
        return MovieMapper.maptoMovieDto(movieRepository.save(movie));
    }

    @Override
    public MovieDto updateMovie(Integer movieId, MovieDto updatedMovie) {
        Movie movie = movieRepository.findById(movieId)
                .map(existingMovie -> {
                    BeanUtils.copyProperties(updatedMovie, existingMovie, "movieId");
                    return movieRepository.save(existingMovie);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + movieId));
        return MovieMapper.maptoMovieDto(movie);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found by id:" + movieId));
        movieRepository.delete(movie);
    }

    @Override
    public List<MovieDto> getMoviesByActorName(String actorName) {
        List<Movie> movies = movieRepository.findAllMoviesByActorName(actorName);
        return movies.stream().map(MovieMapper::maptoMovieDto).collect(Collectors.toList());
    }


}