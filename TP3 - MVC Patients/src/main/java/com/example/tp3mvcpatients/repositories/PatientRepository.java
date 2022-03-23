package com.example.tp3mvcpatients.repositories;

import com.example.tp3mvcpatients.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {
}
