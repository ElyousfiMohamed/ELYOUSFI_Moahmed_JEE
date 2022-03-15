package com.example.manytomanydemo.entities;

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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descri;
    @Column(unique = true, length = 20)
    private  String roleName;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    // @JoinTable(name = "USERS_ROLES") // pour changé le nom du table jointure
    private List<User> users = new ArrayList<>();
}
