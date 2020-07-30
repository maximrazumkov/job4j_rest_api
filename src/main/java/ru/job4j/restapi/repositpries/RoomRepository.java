package ru.job4j.restapi.repositpries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.restapi.domains.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
