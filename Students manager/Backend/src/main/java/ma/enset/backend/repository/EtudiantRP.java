package ma.enset.backend.repository;

import ma.enset.backend.model.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// @RepositoryRestResource(path = "etudiants")
public interface EtudiantRP extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByPrenomContains(String keyword);
    Etudiant findEtudiantById(Long id);
    void deleteEtudiantById(Long id);
    Page<Etudiant> findAll(Pageable pageable);
}
