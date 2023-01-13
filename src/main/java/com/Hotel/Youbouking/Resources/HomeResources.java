package com.Hotel.Youbouking.Resources;

import com.Hotel.Youbouking.Entitys.Hotel;
import com.Hotel.Youbouking.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeResources {
    @Autowired private
    ClientServices clientServices;

    @GetMapping("/hotel/{name}")
    public List<Hotel> getAllHotelsByVille(@PathVariable("name") String name){
        String statut = "valide";
        return clientServices.findHotelByVille(name,statut);
    }
}
