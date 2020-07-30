package ru.job4j.restapi.services.impl;

import org.springframework.stereotype.Service;
import ru.job4j.restapi.domains.Person;
import ru.job4j.restapi.repositpries.PersonRepository;
import ru.job4j.restapi.services.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class SimplePersonService implements PersonService {

    private final PersonRepository personRepository;

    public SimplePersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> findPersonById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }
}
