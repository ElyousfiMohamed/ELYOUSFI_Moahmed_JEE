package com.example.manytomanydemo.service;

import com.example.manytomanydemo.entities.Role;
import com.example.manytomanydemo.entities.User;

public interface UserService {
    User addNewUser (User user);
    Role addNewRole (Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);

}
