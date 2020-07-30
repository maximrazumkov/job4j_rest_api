package ru.job4j.restapi.services;

import ru.job4j.restapi.domains.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAllRoom();
    Optional<Room> findRoomById(Integer id);
}
