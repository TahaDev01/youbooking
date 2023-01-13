package com.Hotel.Youbouking.repository;

import com.Hotel.Youbouking.Entitys.Reservation;
import com.Hotel.Youbouking.Entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    Reservation getReservationByReference(String ref);

    /**@Query("select u.room from Reservation u JOIN Room r where r.number=?1")
    boolean getRoomByReservation(int roomNumber);**/


   /** @Query("SELECT u.room FROM Reservation u JOIN Room r WHERE u=?1 ")
    Room findRoomByReservation(Reservation reservation);**/


}
