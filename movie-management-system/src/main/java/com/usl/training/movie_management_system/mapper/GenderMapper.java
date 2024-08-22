package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.GenderDto;
import com.usl.training.movie_management_system.entity.Gender;

public class GenderMapper {

    //coverts Gender entity object to GenderDto object
    public static GenderDto mapToDto(Gender gender) {
        if (gender == null) return null;

        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(gender.getGenderId());
        genderDto.setGender(gender.getGender());

        return genderDto;
    }

    // converts GenderDto object to a Gender entity object
    public static Gender mapToEntity(GenderDto genderDto){
        if (genderDto == null) return null;

        Gender gender = new Gender();
        gender.setGenderId(genderDto.getGenderId());
        gender.setGender(genderDto.getGender());
        return gender;
    }

}
