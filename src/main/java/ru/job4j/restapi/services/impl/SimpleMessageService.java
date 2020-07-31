package ru.job4j.restapi.services.impl;

import org.springframework.stereotype.Service;
import ru.job4j.restapi.domains.Message;
import ru.job4j.restapi.exceptions.UnauthorizedException;
import ru.job4j.restapi.repositpries.MessageRepository;
import ru.job4j.restapi.services.MessageService;
import ru.job4j.restapi.services.RestClient;

@Service
public class SimpleMessageService implements MessageService {

    private final MessageRepository messageRepository;
    private final RestClient restClient;

    public SimpleMessageService(MessageRepository messageRepository, RestClient restClient) {
        this.messageRepository = messageRepository;
        this.restClient = restClient;
    }

    @Override
    public Message createMessage(Message message) {
        if (!restClient.isAuthorization()) {
            throw new UnauthorizedException("Пользователь не авторизован!");
        }
        return messageRepository.save(message);
    }
}
