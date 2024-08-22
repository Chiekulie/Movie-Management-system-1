package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.CountryDto;
import com.usl.training.movie_management_system.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/movies/countries")
public class CountryController {
    private final CountryService countryService;


    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Integer id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }
    @GetMapping("country")
    public ResponseEntity<CountryDto> getCountryByCountryCode(@RequestParam String countryCode) {
        return ResponseEntity.ok(countryService.getCountryByIsoCode(countryCode));
    }

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.createCountry(countryDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable Integer id, @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.updateCountry(id, countryDto));
    }

    @DeleteMapping("country/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok("Country successfully deleted.");
    }

}
