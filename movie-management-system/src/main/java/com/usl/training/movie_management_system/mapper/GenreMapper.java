package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.GenreDto;
import com.usl.training.movie_management_system.entity.Genre;
public class GenreMapper {

    public static GenreDto mapToDto(Genre genre) {
        return new GenreDto(genre.getGenreId(), genre.getGenreName());
    }

    public static Genre mapToEntity(GenreDto genreDto) {
        return new Genre(genreDto.getGenreId(), genreDto.getGenreName());
    }




}
