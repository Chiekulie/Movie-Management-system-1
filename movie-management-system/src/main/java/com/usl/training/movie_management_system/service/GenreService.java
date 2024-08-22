package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.GenreDto;

import java.util.List;

public interface GenreService {

    GenreDto getGenreById(Integer genreId);
    List<GenreDto> getAllGenres();
    GenreDto createGenre(GenreDto genreDto);
    GenreDto updateGenre(Integer genreId, GenreDto genreDto);
    void deleteGenre(Integer genreId);





}
