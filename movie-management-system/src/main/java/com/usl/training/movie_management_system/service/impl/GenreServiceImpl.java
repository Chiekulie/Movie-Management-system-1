package com.usl.training.movie_management_system.service.impl;
import com.usl.training.movie_management_system.dto.GenreDto;
import com.usl.training.movie_management_system.entity.Genre;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.GenreMapper;
import com.usl.training.movie_management_system.repository.GenreRepository;
import com.usl.training.movie_management_system.service.GenreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@AllArgsConstructor

public class GenreServiceImpl implements GenreService {


    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenreById(Integer genreId) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + genreId));
        return GenreMapper.mapToDto(genre);


    }


    @Override
    public List<GenreDto> getAllGenres() {

        List<Genre> genres = genreRepository.findAll();
        return genres.stream()
                .map(GenreMapper::mapToDto)
                .collect(Collectors.toList());


    }



    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = GenreMapper.mapToEntity(genreDto);
        Genre savedGenre = genreRepository.save(genre);
        return GenreMapper.mapToDto(savedGenre);

    }


    @Override
    public GenreDto updateGenre(Integer genreId, GenreDto genreDto) {
        Genre existingGenre = genreRepository.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + genreId));

        existingGenre.setGenreName(genreDto.getGenreName());


        Genre updatedGenre = genreRepository.save(existingGenre);
        return GenreMapper.mapToDto(updatedGenre);

    }



    @Override
    public void deleteGenre(Integer genreId) {

        genreRepository.deleteById(genreId);
    }
}
