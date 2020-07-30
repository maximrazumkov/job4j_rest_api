package ru.job4j.restapi.services;

import ru.job4j.restapi.domains.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person createPerson(Person person);
    Optional<Person> findPersonById(Integer id);
    List<Person> findAllPerson();
}
