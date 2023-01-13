package com.Hotel.Youbouking.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hotelName;
    private String description;
    private String ville;
    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    private Statut statut ;
    private LocalDateTime createdAt;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Room> rooms;
}
