package com.example.activite_pratique_spring.security.repositories;

import com.example.activite_pratique_spring.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findAppUserByUserName(String username);
}
