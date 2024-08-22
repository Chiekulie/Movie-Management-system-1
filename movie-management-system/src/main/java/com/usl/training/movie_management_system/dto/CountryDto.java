package com.usl.training.movie_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Integer countryId;
    private String countryIsoCode;
    private String countryName;
}
