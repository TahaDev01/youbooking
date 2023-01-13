package com.Hotel.Youbouking.repository;

import com.Hotel.Youbouking.Entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {

    Room getRoomByReference(String ref);
}
