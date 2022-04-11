package com.example.tp3mvcpatients.security.service;

import com.example.tp3mvcpatients.security.entities.AppRole;
import com.example.tp3mvcpatients.security.entities.AppUser;
import com.example.tp3mvcpatients.security.repositories.AppUserRepository;

public interface IServiceSecurity {
    AppUser saveNewUser(String username, String password,String verifyPassword);
    AppRole saveNewRole(String rolename, String Desciption);

    void addRoleToUser(String username,String rolename);
    void delRoleFromUser(String username,String rolename);

    AppUser loadByUserName(String username);
    AppRole loadByRoleName(String rolename);
}
