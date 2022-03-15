package com.example.jpa_associations.repositories;

import com.example.jpa_associations.model.Medecin;
import com.example.jpa_associations.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
