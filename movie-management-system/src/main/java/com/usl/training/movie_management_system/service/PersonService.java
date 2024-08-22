package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto getPersonById(Integer personId);
    List<PersonDto> getAllPersons();
    PersonDto createPerson(PersonDto personDto);
    PersonDto updatePerson(Integer personId, PersonDto personDto);
    void deletePerson(Integer personId);

}
