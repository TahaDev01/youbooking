package com.Hotel.Youbouking.Services;

import com.Hotel.Youbouking.Entitys.Hotel;
import com.Hotel.Youbouking.Entitys.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientServices {

    // ================================== CLIENT SERVICES ===================================== //

    List<Hotel> getAllHotels();
    List<Hotel> findHotelsByVille(String ville);
    Hotel findHotelByName(String name);
    void reservation(Reservation reservation);
    void anullerReservation();

    Reservation editReservation(Reservation reservation);

    boolean getRoomByReservation(int roomNumber);

    List<Reservation> findAllReservation();

    List<Hotel> findHotelByVille(String name, String statut);
}
