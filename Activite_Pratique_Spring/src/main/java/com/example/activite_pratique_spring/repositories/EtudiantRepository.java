package com.example.activite_pratique_spring.repositories;

import com.example.activite_pratique_spring.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByPrenomContains(String keyword, Pageable pageable);
    Etudiant findEtudiantById(Long id);
    void deleteEtudiantById(Long id);
}
