package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.GenreDto;
import com.usl.training.movie_management_system.service.GenreService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("api/movies/genres")
public class GenreController {

    private final GenreService genreService;



    @GetMapping("{genreId}")
    public ResponseEntity<GenreDto> getGenreById(@PathVariable Integer genreId) {
        GenreDto genreDto = genreService.getGenreById(genreId);
        return ResponseEntity.ok(genreDto);
    }



    @GetMapping
    public ResponseEntity<List<GenreDto>> getAllGenres() {
        List<GenreDto> genreDto = genreService.getAllGenres();
        return ResponseEntity.ok(genreDto);
    }



    @PostMapping
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto) {
        GenreDto createdGenre = genreService.createGenre(genreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGenre);
    }



    @PutMapping("/{genreId}")
    public ResponseEntity<GenreDto> updateGenre(
            @PathVariable Integer genreId,
            @RequestBody GenreDto genreDto) {
        GenreDto updatedGenre = genreService.updateGenre(genreId, genreDto);
        return ResponseEntity.ok(updatedGenre);
    }



    @DeleteMapping("/{genreId}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Integer genreId) {
        genreService.deleteGenre(genreId);
        return ResponseEntity.noContent().build();
    }






}
