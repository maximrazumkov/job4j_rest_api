package ru.job4j.restapi.repositpries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.restapi.domains.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
