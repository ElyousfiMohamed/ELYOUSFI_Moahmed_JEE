package com.example.activite_pratique_spring.service;

import com.example.activite_pratique_spring.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IServiceEtudiant {
    void saveEtudiant(Etudiant etudiant);
    Page<Etudiant> findByPrenomContains(String keyword, Pageable pageable);
    void deleteEtudiantById(Long id);
    Etudiant findEtudiantById(Long id);

}
