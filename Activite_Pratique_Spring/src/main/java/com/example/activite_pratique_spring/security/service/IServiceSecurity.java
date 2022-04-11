package com.example.activite_pratique_spring.security.service;

import com.example.activite_pratique_spring.security.entities.*;

public interface IServiceSecurity {
    AppUser saveNewUser(String username, String password, String verifyPassword);
    AppRole saveNewRole(String rolename, String Desciption);

    void addRoleToUser(String username,String rolename);
    void delRoleFromUser(String username,String rolename);

    AppUser loadByUserName(String username);
    AppRole loadByRoleName(String rolename);
}
