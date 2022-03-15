package com.example.manytomanydemo.repositories;

import com.example.manytomanydemo.entities.Role;
import com.example.manytomanydemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
