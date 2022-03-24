package com.example.tp3mvcpatients.repositories;

import com.example.tp3mvcpatients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String keyword, Pageable pageable);
    Patient findPatientById(Long id);

    @Transactional
    @Modifying
    @Query("update Patient p set p.nom = :nom,p.dateNaissance = :ddn,p.malade = :malade,p.score = :score where p.id = :id")
    void updatePatient(@Param(value = "id") long id,
                       @Param(value = "nom") String nom,
                       @Param(value = "ddn") String ddn,
                       @Param(value = "malade") boolean malade,
                       @Param(value = "score") int score);
}
