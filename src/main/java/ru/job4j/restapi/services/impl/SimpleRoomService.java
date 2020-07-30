package ru.job4j.restapi.services.impl;

import org.springframework.stereotype.Service;
import ru.job4j.restapi.domains.Room;
import ru.job4j.restapi.repositpries.RoomRepository;
import ru.job4j.restapi.services.RoomService;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleRoomService implements RoomService {

    private final RoomRepository roomRepository;

    public SimpleRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findRoomById(Integer id) {
        return roomRepository.findById(id);
    }
}
