package com.Hotel.Youbouking.Resources;

import com.Hotel.Youbouking.Entitys.Hotel;
import com.Hotel.Youbouking.Entitys.Reservation;
import com.Hotel.Youbouking.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientResources {
    @Autowired private ClientServices clientServices;

    @PostMapping("/Reservation")
    public void reservation(@RequestBody Reservation reservation){
        clientServices.reservation(reservation);
    }

    @GetMapping("/Reservation")
    public List<Reservation> getAll(){
        return clientServices.findAllReservation();
    }

    @PutMapping("/Reservation")
    public Reservation editReservation(@RequestBody Reservation reservation){
        return clientServices.editReservation(reservation);
    }

    @GetMapping ("getAllHotels")
    public List<Hotel> getAllHotels(){
        return  clientServices.getAllHotels();
    }
}
