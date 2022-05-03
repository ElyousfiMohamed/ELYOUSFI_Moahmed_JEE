package ma.enset.backend.dto.converter;

import ma.enset.backend.dto.EtudiantDto;
import ma.enset.backend.model.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EtudiantConverter {
    public EtudiantDto etudiantToDto(Etudiant etudiant) {
        EtudiantDto etudiantDto = new EtudiantDto();
        BeanUtils.copyProperties(etudiant,etudiantDto);
        return etudiantDto;
    }

    public Etudiant dtoToEtudiant(EtudiantDto etudiantDto) {
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDto,etudiant);
        return etudiant;
    }

    public List<EtudiantDto> etudiantToDto(List<Etudiant> etudiants) {
        return etudiants.stream().map(e -> etudiantToDto(e)).collect(Collectors.toList());
    }

    public List<Etudiant> dtoToEtudiant(List<EtudiantDto> etudiantDtos) {
        return etudiantDtos.stream().map(e -> dtoToEtudiant(e)).collect(Collectors.toList());
    }

}
