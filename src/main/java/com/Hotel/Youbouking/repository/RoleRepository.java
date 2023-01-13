package com.Hotel.Youbouking.repository;

import com.Hotel.Youbouking.Entitys.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByRoleName(String roleName);
}
