package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.PersonDto;
import com.usl.training.movie_management_system.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public static Person mapToPerson(PersonDto personDto) {
        if (personDto == null) {
            throw new NullPointerException();
        }
        Person person = new Person();

        person.setPersonId(personDto.getPersonId());
        person.setActorName(personDto.getActorName());
        return person;
    }
    public static PersonDto mapToPersonDto(Person person) {
        if (person == null) {
            throw new NullPointerException();
        }
        PersonDto personDto = new PersonDto();

        personDto.setPersonId(person.getPersonId());
        personDto.setActorName(person.getActorName());
        return personDto;
    }
}
