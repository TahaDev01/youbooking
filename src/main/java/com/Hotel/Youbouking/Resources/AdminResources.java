package com.Hotel.Youbouking.Resources;

import com.Hotel.Youbouking.Entitys.*;
import com.Hotel.Youbouking.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
@EnableAsync
public class AdminResources {
    @Autowired
    AdminServices adminServices;
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return  adminServices.createUser(user);
    }

    @PostMapping("/createRole")
    public Role createRole(@RequestBody Role role){
        return adminServices.createRole(role);
    }

    @PostMapping("addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUser roleUser){
           adminServices.addRoleToUser(roleUser.getUserName(),roleUser.getRoleName());
    }

    @PostMapping("addStatutToReservation")
    public void addRoleToUser(@RequestBody StatutReservation statut){
        adminServices.addStatutToReservation(statut.getStatut(),statut.getRef());
    }

    @PutMapping("/editHotel")
    public Hotel editHotel(@RequestBody Hotel hotel){
         return adminServices.createHotel(hotel);
    }


    @PostMapping("/createHotel")
    public  Hotel createHotel(@RequestBody Hotel hotel){
        return  adminServices.createHotel(hotel);
    }

    @GetMapping("/getAllHotels")
    public List<Hotel> getAll(){
        return adminServices.getAllHotels();
    }

    @PostMapping("/addStatutToHotel")
    public void addStatutToHotel(@RequestBody StatutHotel statutHotel){
        adminServices.addStatutToHotel(statutHotel.getStatut(),statutHotel.getHootelName());
    }

    @PostMapping("/addStatutToRoom")
    public void addStatutToHotel(@RequestBody StatutRoom statutRoom){
        adminServices.addStautToRoom(statutRoom.getNumberRoom(),statutRoom.getNameHotel(), statutRoom.getStatut());
    }

    @PostMapping("/createRoom")
    public Room createRoom(@RequestBody Room room){
        return adminServices.createRoom(room);
    }

    @PutMapping("/editRoom")
    public Room editRoom(@RequestBody Room room){return adminServices.createRoom(room);}

    @PostMapping("/addRoomToHotel")
    public void addRoomToHotel(@RequestBody RoomHotel roomHotel){
        adminServices.addRoomToHotel(roomHotel.getHotelName(),roomHotel.getRef());
    }

    @DeleteMapping("/delateRoom/{id}")
    public void deleteRoom(@PathVariable("id") Long id){
        adminServices.deleteRoom(id);
    }

    @DeleteMapping("/delateHotel/{id}")
    public void deleteHotel(@PathVariable("id") Long id){
        adminServices.deleteHotel(id);
    }

    @GetMapping("getAllRoom")
    public List<Room> getAllRoom(){
        return adminServices.getAllRoom();
    }


    @GetMapping("/getAllStatut")
    public List<Statut> getAllStatut(){
        return adminServices.getAllStatut();
    }

}
