package com.example.activite_pratique_spring.security.service;

import com.example.activite_pratique_spring.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SecurityDetailsService implements UserDetailsService {

    private IServiceSecurity iServiceSecurity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iServiceSecurity.loadByUserName(username);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppRoles().forEach(appRole -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority((appRole.getRoleName()));
            authorities.add(authority);
        });

        Collection<GrantedAuthority> authorities1 =
                appUser.getAppRoles().stream().map(appRole ->
                    new SimpleGrantedAuthority((appRole.getRoleName())))
                        .collect(Collectors.toList());

        User user = new User(appUser.getUserName(), appUser.getPassword(), authorities1);
        return user;
    }

}
