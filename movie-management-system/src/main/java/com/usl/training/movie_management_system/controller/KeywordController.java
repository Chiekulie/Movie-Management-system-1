package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.KeywordDto;
import com.usl.training.movie_management_system.service.KeywordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/movies/keywords")
public class KeywordController {
    private KeywordService keywordService;

    @GetMapping
    public ResponseEntity<List<KeywordDto>> getAllKeywords() {
        return ResponseEntity.ok(keywordService.getAllKeywords());
    }

    @GetMapping("{id}")
    public ResponseEntity<KeywordDto> getKeywordById(@PathVariable Integer id) {
        return ResponseEntity.ok(keywordService.getKeywordById(id));
    }

    @PostMapping
    public ResponseEntity<KeywordDto> createKeyword(@RequestBody KeywordDto keywordDto) {
        return new ResponseEntity<>(keywordService.createKeyword(keywordDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteKeyword(@PathVariable Integer id) {
        keywordService.deleteKeyword(id);
        return ResponseEntity.ok("Keyword deleted successfully.");
    }

    @PutMapping("{id}")
    public ResponseEntity<KeywordDto> updateKeyword(@PathVariable Integer id, @RequestBody KeywordDto keywordDto) {
        return ResponseEntity.ok(keywordService.updateKeyword(id, keywordDto));
    }
}
