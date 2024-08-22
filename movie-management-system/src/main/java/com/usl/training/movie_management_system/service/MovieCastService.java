package com.usl.training.movie_management_system.service;


import com.usl.training.movie_management_system.dto.MovieCastDto;
import com.usl.training.movie_management_system.dto.MovieDto;



import java.util.List;


public interface MovieCastService {
    List<MovieCastDto> getAllMovieCasts();
    List<MovieCastDto> getMovieCastsByMovieTitle(String title);

}
