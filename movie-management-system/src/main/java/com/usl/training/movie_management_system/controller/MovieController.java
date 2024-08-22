package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.MovieDto;

import com.usl.training.movie_management_system.service.MovieService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping("/title")
    public ResponseEntity<MovieDto> getMovieByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.createMovie(movieDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Integer movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Movie deleted successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") Integer movieId, @RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(movieService.updateMovie(movieId, movieDto));
    }

    @GetMapping("/actor")
    public ResponseEntity<List<MovieDto>> getMoviesByActorName(@RequestParam String name) {
        return ResponseEntity.ok(movieService.getMoviesByActorName(name));
    }


}
