package com.usl.training.movie_management_system.service.impl;


import com.usl.training.movie_management_system.dto.CountryDto;
import com.usl.training.movie_management_system.entity.Country;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.CountryMapper;
import com.usl.training.movie_management_system.repository.CountryRepository;
import com.usl.training.movie_management_system.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Override
    public CountryDto getCountryByIsoCode(String isoCode) {
        Country country = countryRepository.findByCountryIsoCode(isoCode);
        return CountryMapper.maptoCountryDto(country);
    }

    @Override
    public CountryDto getCountryById(Integer countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Country not found with id " + countryId));
        return CountryMapper.maptoCountryDto(country);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(CountryMapper::maptoCountryDto).collect(Collectors.toList());
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {

        Country country = CountryMapper.maptoCountry(countryDto);
        if (country.getCountryIsoCode().length() != 2) {
            throw new IllegalArgumentException("ISO code must be exactly 2 characters long");
        }
        return CountryMapper.maptoCountryDto(countryRepository.save(country));
    }

    @Override
    public CountryDto updateCountry(Integer countryId, CountryDto countryDto) {
        if (countryDto.getCountryIsoCode().length() != 2) {
            throw new IllegalArgumentException("ISO code must be exactly 2 characters long");
        }
        Country updatedCountry = countryRepository.findById(countryId).map(country -> {
                    BeanUtils.copyProperties(countryDto, country, "countryId");
                    return countryRepository.save(country);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + countryId));

        return CountryMapper.maptoCountryDto(updatedCountry);

    }

    @Override
    public void deleteCountry(Integer countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + countryId));
        countryRepository.delete(country);
    }
}
