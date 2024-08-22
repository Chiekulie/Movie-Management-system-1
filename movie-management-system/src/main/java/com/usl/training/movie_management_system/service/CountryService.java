package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.CountryDto;

import java.util.List;


public interface CountryService {
    CountryDto getCountryByIsoCode(String isoCode);
    CountryDto getCountryById(Integer countryId);
    List<CountryDto> getAllCountries();
    CountryDto createCountry(CountryDto countryDto);
    CountryDto updateCountry(Integer countryId, CountryDto countryDto);
    void deleteCountry(Integer countryId);
}
