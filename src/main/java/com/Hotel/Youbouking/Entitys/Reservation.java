package com.Hotel.Youbouking.Entitys;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    private Date dateFin;
    private String reference;
    @ManyToOne(fetch = FetchType.EAGER)
    private Statut statut;
    @OneToMany()
    private Collection<Room> room = new ArrayList<>();

}
