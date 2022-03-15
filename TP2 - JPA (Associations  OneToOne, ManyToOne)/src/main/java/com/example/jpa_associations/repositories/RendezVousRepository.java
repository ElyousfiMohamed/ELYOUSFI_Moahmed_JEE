package com.example.jpa_associations.repositories;

import com.example.jpa_associations.model.Patient;
import com.example.jpa_associations.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

}
