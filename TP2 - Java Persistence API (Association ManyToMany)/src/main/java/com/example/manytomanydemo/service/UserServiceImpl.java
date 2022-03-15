package com.example.manytomanydemo.service;

import com.example.manytomanydemo.entities.Role;
import com.example.manytomanydemo.entities.User;
import com.example.manytomanydemo.repositories.RoleRepository;
import com.example.manytomanydemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
        user.getRoles().add(role);
        role.getUsers().add(user);

    }
}
