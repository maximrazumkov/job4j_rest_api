package ru.job4j.restapi.services.impl;

import org.springframework.stereotype.Service;
import ru.job4j.restapi.domains.Message;
import ru.job4j.restapi.repositpries.MessageRepository;
import ru.job4j.restapi.services.MessageService;

@Service
public class SimpleMessageService implements MessageService {

    private final MessageRepository messageRepository;

    public SimpleMessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
