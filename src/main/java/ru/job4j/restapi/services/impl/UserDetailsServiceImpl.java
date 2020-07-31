package ru.job4j.restapi.services.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.restapi.domains.Person;
import ru.job4j.restapi.repositpries.PersonRepository;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private PersonRepository personRepository;

    public UserDetailsServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Person> users = personRepository.findByUsername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        Person person = users.get(0);
        return new User(person.getUsername(), person.getPassword(), emptyList());
    }
}
