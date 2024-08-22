package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.PersonDto;
import com.usl.training.movie_management_system.service.PersonService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Data
@RestController
@RequestMapping("api/movies/actors")
public class PersonController {

    private final PersonService personService;


    @GetMapping("{personId}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Integer personId) {
        PersonDto personDto = personService.getPersonById(personId);
        return ResponseEntity.ok(personDto);
    }



    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> personDto = personService.getAllPersons();
        return ResponseEntity.ok(personDto);
    }




    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto createdPerson = personService.createPerson(personDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }



    @PutMapping("{personId}")
    public ResponseEntity<PersonDto> updatePerson(
            @PathVariable Integer personId,
            @RequestBody PersonDto personDto) {
        PersonDto updatedPerson = personService.updatePerson(personId, personDto);
        return ResponseEntity.ok(updatedPerson);
    }




    @DeleteMapping("{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }













}
