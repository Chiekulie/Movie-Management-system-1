package com.usl.training.movie_management_system.mapper;


import com.usl.training.movie_management_system.dto.MovieDto;
import com.usl.training.movie_management_system.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public static Movie maptoMovie(MovieDto movieDto){
        if (movieDto == null) return null;
        Movie movie = new Movie();
        movie.setMovieId(movieDto.getMovieId());
        movie.setTitle(movieDto.getTitle());
        movie.setBudget(movieDto.getBudget());
        movie.setHomepage(movieDto.getHomepage());
        movie.setOverview(movieDto.getOverview());
        movie.setPopularity(movieDto.getPopularity());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setRevenue(movieDto.getRevenue());
        movie.setRuntime(movieDto.getRuntime());
        movie.setMovieStatus(movieDto.getMovieStatus());
        movie.setTagline(movieDto.getTagline());
        movie.setVotesAvg(movieDto.getVotesAvg());
        movie.setVotesCount(movieDto.getVotesCount());
        return movie;
    }
    public static MovieDto maptoMovieDto(Movie movie){
        if (movie == null) return null;
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setBudget(movie.getBudget());
        movieDto.setHomepage(movie.getHomepage());
        movieDto.setOverview(movie.getOverview());
        movieDto.setPopularity(movie.getPopularity());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setRevenue(movie.getRevenue());
        movieDto.setRuntime(movie.getRuntime());
        movieDto.setMovieStatus(movie.getMovieStatus());
        movieDto.setTagline(movie.getTagline());
        movieDto.setVotesAvg(movie.getVotesAvg());
        movieDto.setVotesCount(movie.getVotesCount());
        return movieDto;
    }
}