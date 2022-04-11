package com.example.activite_pratique_spring.service;

import com.example.activite_pratique_spring.entities.Etudiant;
import com.example.activite_pratique_spring.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ServiceEtudiantImpl implements IServiceEtudiant{
    private EtudiantRepository etudiantRepository;

    @Override
    public void saveEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    @Override
    public Page<Etudiant> findByPrenomContains(String keyword, Pageable pageable) {
        return etudiantRepository.findByPrenomContains(keyword,pageable);
    }

    @Override
    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteEtudiantById(id);
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        return etudiantRepository.findEtudiantById(id);
    }
}
