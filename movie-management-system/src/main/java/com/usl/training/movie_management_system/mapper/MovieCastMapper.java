package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.MovieCastDto;
import com.usl.training.movie_management_system.entity.MovieCast;
import com.usl.training.movie_management_system.entity.MovieCastId;
import org.springframework.stereotype.Component;

@Component
public class MovieCastMapper {
    public static MovieCast mapToMovieCast(MovieCastDto movieCastDto) {
        if (movieCastDto == null) {
            return null;
        }
        MovieCast movieCast = new MovieCast();
//        movieCast.setId(new MovieCastId(movieCastDto.getPersonId(), movieCastDto.getMovieId()));
        movieCast.setCharacterName(movieCastDto.getCharacterName());

        return movieCast;
    }
    public static MovieCastDto mapToMovieCastDto(MovieCast movieCast) {
        if (movieCast == null) {
            return null;
        }
        MovieCastDto movieCastDto = new MovieCastDto();
//        movieCastDto.setPersonId(movieCast.getPerson().getPersonId());
//        movieCastDto.setMovieId(movieCast.getMovie().getMovieId());
        movieCastDto.setCharacterName(movieCast.getCharacterName());
        movieCastDto.setActorName(movieCast.getPerson().getActorName());

        return movieCastDto;
    }
}
