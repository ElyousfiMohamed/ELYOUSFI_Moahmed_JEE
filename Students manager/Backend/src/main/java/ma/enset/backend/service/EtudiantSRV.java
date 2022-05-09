package ma.enset.backend.service;

import ma.enset.backend.dto.EtudiantDto;
import ma.enset.backend.model.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EtudiantSRV {
    Etudiant saveEtudiant(Etudiant e);
    List<Etudiant> findByPrenomContains(String keyword);
    Page<EtudiantDto> findAll(Pageable pageable);
    Etudiant findEtudiantById(Long id);
    void deleteEtudiantById(Long id);
}
