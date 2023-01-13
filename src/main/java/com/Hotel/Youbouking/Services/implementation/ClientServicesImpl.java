package com.Hotel.Youbouking.Services.implementation;

import com.Hotel.Youbouking.Entitys.Hotel;
import com.Hotel.Youbouking.Entitys.Reservation;
import com.Hotel.Youbouking.Services.ClientServices;
import com.Hotel.Youbouking.repository.HotelRepository;
import com.Hotel.Youbouking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServicesImpl implements ClientServices {
    @Autowired private AdminServicesImpl adminServices; @Autowired HotelRepository hotelRepository;

    @Autowired private ReservationRepository reservationRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAllHotel("valide");
    }

    @Override
    public List<Hotel> findHotelsByVille(String ville) {
        return hotelRepository.findHoteByVille(ville);
    }

    @Override
    public Hotel findHotelByName(String name) {
        return hotelRepository.findHotelByHotelName(name);
    }

    @Override
    public void reservation(Reservation reservation) {
        reservation.setReference(UUID.randomUUID().toString());
        reservationRepository.save(reservation);
    }



    @Override
    public void anullerReservation() {

    }

    @Override
    public Reservation editReservation(Reservation reservation) {
        return reservationRepository.save(reservation);

    }

    @Override
    public boolean getRoomByReservation(int roomNumber) {
        return false;
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Hotel> findHotelByVille(String name ,String statut) {
        return  hotelRepository.findByVilleAndStatutStatutName(name,statut);
    }


}
