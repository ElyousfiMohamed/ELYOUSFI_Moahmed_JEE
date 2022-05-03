package ma.enset.backend.service;

import lombok.AllArgsConstructor;
import ma.enset.backend.model.Etudiant;
import ma.enset.backend.repository.EtudiantRP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplEtudiantSRV implements EtudiantSRV{

    EtudiantRP etudiantRP;

    @Override
    public Etudiant saveEtudiant(Etudiant e) {
        return etudiantRP.save(e);
    }

    @Override
    public List<Etudiant> findByPrenomContains(String keyword) {
        return etudiantRP.findByPrenomContains(keyword);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRP.findAll();
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        return etudiantRP.findEtudiantById(id);
    }

    @Override
    public void deleteEtudiantById(Long id) {
        etudiantRP.deleteEtudiantById(id);
    }
}
