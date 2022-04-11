package com.example.tp3mvcpatients.security.repositories;

import com.example.tp3mvcpatients.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findAppRoleByRoleName(String rolename);
}
