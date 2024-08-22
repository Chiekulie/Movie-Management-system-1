package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.CountryDto;
import com.usl.training.movie_management_system.entity.Country;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryMapper {
    public static Country maptoCountry(CountryDto countryDto) {
        if (countryDto == null) {
            return null;
        }
        Country country = new Country();
        country.setCountryId(countryDto.getCountryId());
        country.setCountryIsoCode(countryDto.getCountryIsoCode());
        country.setCountryName(countryDto.getCountryName());
        return country;
    }

    public static CountryDto maptoCountryDto(Country country) {
        if (country == null) {
            return null;
        }
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(country.getCountryId());
        countryDto.setCountryIsoCode(country.getCountryIsoCode());
        countryDto.setCountryName(country.getCountryName());
        return countryDto;
    }
}
