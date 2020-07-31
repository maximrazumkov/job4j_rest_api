package ru.job4j.restapi.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.restapi.domains.Person;
import ru.job4j.restapi.exceptions.UnauthorizedException;
import ru.job4j.restapi.repositpries.PersonRepository;
import ru.job4j.restapi.services.PersonService;
import ru.job4j.restapi.services.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class SimplePersonService implements PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder encoder;
    private final RestClient restClient;

    public SimplePersonService(PersonRepository personRepository, PasswordEncoder encoder, RestClient restClient) {
        this.personRepository = personRepository;
        this.encoder = encoder;
        this.restClient = restClient;
    }

    @Override
    public Person createPerson(Person person) {
        if (!restClient.isAuthorization()) {
            throw new UnauthorizedException("Пользователь не авторизован!");
        }
        person.setPassword(encoder.encode(person.getPassword()));
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
