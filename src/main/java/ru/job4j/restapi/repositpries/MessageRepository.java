package ru.job4j.restapi.repositpries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.restapi.domains.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
