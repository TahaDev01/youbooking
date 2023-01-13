package com.Hotel.Youbouking.repository;

import com.Hotel.Youbouking.Entitys.Role;
import com.Hotel.Youbouking.Entitys.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutRepository extends JpaRepository<Statut,Long> {
    Statut getStatutByStatutName(String statutName);
}
