package com.example.tp3mvcpatients.security.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

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
