package ru.job4j.restapi.services;

import ru.job4j.restapi.domains.Message;

public interface MessageService {
    Message createMessage(Message message);
}
