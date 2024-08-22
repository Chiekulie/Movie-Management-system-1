package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.GenderDto;
import com.usl.training.movie_management_system.service.GenderService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("api/movies/genders")
public class GenderController {

    private final GenderService genderService;



    @GetMapping("{genderId}")
    public ResponseEntity<GenderDto> getGenderById(@PathVariable Integer genderId) {
        GenderDto genderDto = genderService.getGenderById(genderId);
        return ResponseEntity.ok(genderDto);
    }



    @GetMapping
    public ResponseEntity<List<GenderDto>> getAllGenders() {
        List<GenderDto> genderDto = genderService.getAllGenders();
        return ResponseEntity.ok(genderDto);
    }



    @PostMapping
    public ResponseEntity<GenderDto> createGender(@RequestBody GenderDto genderDto) {
        GenderDto createdGender = genderService.createGender(genderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGender);
    }



    @PutMapping("{genderId}")
    public ResponseEntity<GenderDto> updateGender(
            @PathVariable Integer genderId,
            @RequestBody GenderDto genderDto) {
        GenderDto updatedGender = genderService.updateGender(genderId, genderDto);
        return ResponseEntity.ok(updatedGender);
    }



    @DeleteMapping("{genderId}")
    public ResponseEntity<Void> deleteGender(@PathVariable Integer genderId) {
        genderService.deleteGender(genderId);
        return ResponseEntity.noContent().build();
    }

}
