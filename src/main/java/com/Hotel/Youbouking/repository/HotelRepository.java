package com.Hotel.Youbouking.repository;

import com.Hotel.Youbouking.Entitys.Hotel;
import com.Hotel.Youbouking.Entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query("SELECT u FROM Hotel u JOIN u.statut s WHERE  s.statutName =?1")
    List<Hotel> findAllHotel(String keyword);
    @Query("select u.rooms from Hotel u JOIN u.rooms r WHERE u.hotelName=?1 and r.number=?2")
    Room findHotelByRooms(String hotelName,int chemberNumber);
    Hotel findHotelByHotelName(String hotelName);
    List<Hotel> findHoteByVille(String ville);
    //@Query("SELECT u FROM  Hotel u join Statut s where u.ville=?1 and s.statutName=?2")

    List<Hotel> findByVilleAndStatutStatutName(String ville, String name);
}
