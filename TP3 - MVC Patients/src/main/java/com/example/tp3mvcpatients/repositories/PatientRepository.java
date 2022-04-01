package com.example.tp3mvcpatients.repositories;

import com.example.tp3mvcpatients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String keyword, Pageable pageable);
    Patient findPatientById(Long id);

}
