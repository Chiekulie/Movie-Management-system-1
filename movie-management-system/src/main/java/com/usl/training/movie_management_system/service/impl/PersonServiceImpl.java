package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.PersonDto;
import com.usl.training.movie_management_system.entity.Person;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.PersonMapper;
import com.usl.training.movie_management_system.repository.PersonRepository;
import com.usl.training.movie_management_system.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@Service


public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;

    @Override
    public PersonDto getPersonById(Integer personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + personId));
        return PersonMapper.mapToPersonDto(person);

    }



    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(PersonMapper::mapToPersonDto)
                .collect(Collectors.toList());

    }




    @Override
    public PersonDto createPerson(PersonDto personDto) {

        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = personRepository.save(person);
        return PersonMapper.mapToPersonDto(savedPerson);


    }




    @Override
    public PersonDto updatePerson(Integer personId, PersonDto personDto) {

        Person existingPerson = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + personId));

        existingPerson.setActorName(personDto.getActorName());

        Person updatedPerson = personRepository.save(existingPerson);
        return PersonMapper.mapToPersonDto(updatedPerson);


    }


    @Override
    public void deletePerson(Integer personId) {

        personRepository.deleteById(personId);

    }



}
