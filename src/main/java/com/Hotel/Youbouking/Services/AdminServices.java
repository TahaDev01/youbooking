package com.Hotel.Youbouking.Services;

import com.Hotel.Youbouking.Entitys.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminServices {

    // ============================== admin services ===================================== //
    User createUser(User user);
    Role createRole(Role role);
    void addRoleToUser(String username , String role);
    Hotel createHotel(Hotel hotel);
    Room createRoom(Room room);
    void addRoomToHotel(String hotelName , String ref);
    void deleteHotel(Long id);
    void deleteRoom(Long id);
    void editRoom(Room room);
    Statut getStatutByName(String name);
    void addStatutToReservation(String statut , String ref);
    List<Hotel> getAllHotels();
   void addStatutToHotel(String statut , String hotelName);
   void addStautToRoom(int roomnumber , String hotelName , String staut);
   List<Room> getAllRoom();
   List<Statut> getAllStatut();

}
