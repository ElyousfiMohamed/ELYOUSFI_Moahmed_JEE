package com.example.activite_pratique_spring.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(unique = true, length = 20)
    private  String roleName;
    @ManyToMany(mappedBy = "appRoles",fetch = FetchType.EAGER)
    // @JoinTable(name = "USERS_ROLES") // pour changé le nom du table jointure
    private List<AppUser> appUsers = new ArrayList<>();
}
