package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.LanguageDto;
import com.usl.training.movie_management_system.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies/languages")
public class LanguageController {
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAllLanguages() {
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

    @GetMapping("{id}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Integer id) {
        return ResponseEntity.ok(languageService.getLanguageById(id));
    }

    @PostMapping
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody LanguageDto languageDto) {
        return new ResponseEntity<>(languageService.createLanguage(languageDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<LanguageDto> updateLanguage(@PathVariable Integer id, @RequestBody LanguageDto languageDto) {
        return ResponseEntity.ok(languageService.updateLanguage(id, languageDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable Integer id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.ok("Deleted language Successfully.");
    }
}
