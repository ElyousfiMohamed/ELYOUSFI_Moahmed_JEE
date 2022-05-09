package ma.enset.backend.service;

import lombok.AllArgsConstructor;
import ma.enset.backend.dto.EtudiantDto;
import ma.enset.backend.dto.converter.EtudiantConverter;
import ma.enset.backend.model.Etudiant;
import ma.enset.backend.repository.EtudiantRP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class ImplEtudiantSRV implements EtudiantSRV {

    EtudiantRP etudiantRP;
    EtudiantConverter converter;

    @Override
    public Etudiant saveEtudiant(Etudiant e) {
        return etudiantRP.save(e);
    }

    @Override
    public List<Etudiant> findByPrenomContains(String keyword) {
        return etudiantRP.findByPrenomContains(keyword);
    }

    @Override
    public Page<EtudiantDto> findAll(Pageable pageable) {
        Page<EtudiantDto> dtoPage = new Page<EtudiantDto>() {
            @Override
            public int getTotalPages() {
                return etudiantRP.findAll(pageable).getTotalPages();
            }

            @Override
            public long getTotalElements() {
                return etudiantRP.findAll(pageable).getTotalElements();
            }

            @Override
            public <U> Page<U> map(Function<? super EtudiantDto, ? extends U> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return etudiantRP.findAll(pageable).getNumber();
            }

            @Override
            public int getSize() {
                return etudiantRP.findAll(pageable).getSize();
            }

            @Override
            public int getNumberOfElements() {
                return etudiantRP.findAll(pageable).getNumberOfElements();
            }

            @Override
            public List<EtudiantDto> getContent() {
                return converter.etudiantToDto(etudiantRP.findAll(pageable).getContent());
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return etudiantRP.findAll(pageable).nextPageable();
            }

            @Override
            public Pageable previousPageable() {
                return etudiantRP.findAll(pageable).previousPageable();
            }

            @Override
            public Iterator<EtudiantDto> iterator() {
                return converter.etudiantToDto(etudiantRP.findAll(pageable).getContent()).iterator();
            }
        };
        return dtoPage;
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
