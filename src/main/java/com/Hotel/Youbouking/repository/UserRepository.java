package com.Hotel.Youbouking.repository;

import com.Hotel.Youbouking.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String username);
}
