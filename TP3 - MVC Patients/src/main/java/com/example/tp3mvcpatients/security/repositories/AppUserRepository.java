package com.example.tp3mvcpatients.security.repositories;

import com.example.tp3mvcpatients.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findAppUserByUserName(String username);
}
