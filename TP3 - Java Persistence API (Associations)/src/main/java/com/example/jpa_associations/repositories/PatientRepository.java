package com.example.jpa_associations.repositories;


import com.example.jpa_associations.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);

}
