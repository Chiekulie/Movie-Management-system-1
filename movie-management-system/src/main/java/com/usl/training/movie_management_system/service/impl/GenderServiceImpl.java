package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.GenderDto;
import com.usl.training.movie_management_system.entity.Gender;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.GenderMapper;
import com.usl.training.movie_management_system.repository.GenderRepository;
import com.usl.training.movie_management_system.service.GenderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service

public class GenderServiceImpl implements GenderService {


    private final GenderRepository genderRepository;

    @Override
    public GenderDto getGenderById(Integer genderId) {

        Gender gender = genderRepository.findById(genderId)
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + genderId));
        return GenderMapper.mapToDto(gender);
    }




    @Override
    public List<GenderDto> getAllGenders() {
        List<Gender> genders = genderRepository.findAll();
        return genders.stream()
                .map(GenderMapper::mapToDto)
                .collect(Collectors.toList());
    }



    @Override
    public GenderDto createGender(GenderDto genderDto) {
        Gender gender = GenderMapper.mapToEntity(genderDto);
        Gender savedGender = genderRepository.save(gender);
        return GenderMapper.mapToDto(savedGender);
    }




    @Override
    public GenderDto updateGender(Integer genderId, GenderDto genderDto) {
        Gender existingGender = genderRepository.findById(genderId)
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + genderId));

        existingGender.setGender(genderDto.getGender());

        Gender updatedGender = genderRepository.save(existingGender);
        return GenderMapper.mapToDto(updatedGender);


    }

    @Override
    public void deleteGender(Integer genderId) {
        genderRepository.deleteById(genderId);
    }


}
