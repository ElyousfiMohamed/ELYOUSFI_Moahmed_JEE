package com.example.jpa_associations.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private Boolean malade;
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;




}
