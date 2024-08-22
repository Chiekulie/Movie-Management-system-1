package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.GenderDto;

import java.util.List;

public interface GenderService {

    GenderDto getGenderById(Integer genderId);
    List<GenderDto> getAllGenders();
    GenderDto createGender(GenderDto genderDto);
    GenderDto updateGender(Integer genderId, GenderDto genderDto);

    void deleteGender(Integer genderId);
}
