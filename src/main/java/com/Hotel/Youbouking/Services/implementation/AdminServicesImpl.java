package com.Hotel.Youbouking.Services.implementation;

import com.Hotel.Youbouking.Entitys.*;
import com.Hotel.Youbouking.Resources.StatutReservation;
import com.Hotel.Youbouking.Services.AdminServices;
import com.Hotel.Youbouking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class AdminServicesImpl implements AdminServices {
    @Autowired private UserRepository userRepository; @Autowired RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder; @Autowired HotelRepository hotelRepository;@Autowired StatutRepository statutRepository;
    @Autowired private RoomRepository  roomRepository; @Autowired ReservationRepository reservationRepository;

    @Override
    public User createUser(User user){
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = userRepository.findUserByUserName(username);
        Role rol = roleRepository.findRoleByRoleName(role);
        user.getRoles().add(rol);
    }

    @Override
    public Hotel createHotel(Hotel hotel){
        hotel.setCreatedAt(LocalDateTime.now());
        Statut statut = hotel.getStatut();
        if(statut==null){
            Statut  statut1 = this.getStatutByName("non valide");
            hotel.setStatut(statut1);
        }
        return hotelRepository.save(hotel);
    }

    @Override
    public Room createRoom(Room room) {
        if (room.getReference()==null)room.setReference(UUID.randomUUID().toString());
        Statut statut = this.getStatutByName(room.getStatutName());
        room.setStatut(statut);
        return roomRepository.save(room);
    }
    @Override
    public void addRoomToHotel(String hotelName, String ref) {
        Hotel hotel = hotelRepository.findHotelByHotelName(hotelName);
        Room room = roomRepository.getRoomByReference(ref);
        hotel.getRooms().add(room);
    }

    @Override
    public void deleteHotel(Long id) {
         hotelRepository.deleteById(id);
    }


    @Override
    public void deleteRoom(Long id) {
       roomRepository.deleteById(id);
    }

    @Override
    public void editRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Statut getStatutByName(String name){
        return statutRepository.getStatutByStatutName(name);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void addStatutToHotel(String statut, String hotelName) {
         Statut statut1 = this.getStatutByName(statut);
         Hotel hotel = hotelRepository.findHotelByHotelName(hotelName);
         hotel.setStatut(statut1);
    }

    @Override
    public void addStatutToReservation(String statut ,String ref) {
        Reservation reservation = reservationRepository.getReservationByReference(ref);
        Statut statut1 = this.getStatutByName(statut);
        reservation.setStatut(statut1);
    }


    @Override
    public void addStautToRoom(int roomnumber, String hotelName, String staut) {
        Room room = hotelRepository.findHotelByRooms(hotelName,roomnumber);
        Statut statut = statutRepository.getStatutByStatutName(staut);
        room.setStatut(statut);
    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public List<Statut> getAllStatut() {
        return statutRepository.findAll();
    }
}
