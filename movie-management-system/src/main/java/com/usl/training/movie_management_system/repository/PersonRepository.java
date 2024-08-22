package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Integer> {

}
