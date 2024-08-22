package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.MovieCastDto;
import com.usl.training.movie_management_system.service.MovieCastService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies/cast")
public class MovieCastController {
    private final MovieCastService movieCastService;

    @GetMapping
    public ResponseEntity<List<MovieCastDto>> getAllMovieCast() {
        return ResponseEntity.ok(movieCastService.getAllMovieCasts());
    }

    @GetMapping("/movie")
    public ResponseEntity<List<MovieCastDto>> getMovieCastByMovieTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieCastService.getMovieCastsByMovieTitle(title));
    }

}
