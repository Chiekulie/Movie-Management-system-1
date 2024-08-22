package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByCountryIsoCode(String countryIsoCode);

}
