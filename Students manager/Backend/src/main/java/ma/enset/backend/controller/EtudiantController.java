package ma.enset.backend.controller;

import lombok.AllArgsConstructor;
import ma.enset.backend.dto.EtudiantDto;
import ma.enset.backend.dto.converter.EtudiantConverter;
import ma.enset.backend.model.Etudiant;
import ma.enset.backend.service.EtudiantSRV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@AllArgsConstructor
@RestController
public class EtudiantController {
    EtudiantSRV service;
    EtudiantConverter converter;

    @GetMapping("/etudiants")
    public List<EtudiantDto> etudiantList(@RequestParam(name = "page", defaultValue = "0") int page,
                                          @RequestParam(name = "size", defaultValue = "6") int size) {
            return service.findAll(PageRequest.of(page,size)).getContent();
    }

    @GetMapping("/etudiants/{id}")
    public EtudiantDto etudiant(@PathVariable(name = "id") Long id) {
        return converter.etudiantToDto(service.findEtudiantById(id));
    }

    @PostMapping("/etudiants")
    public EtudiantDto saveEtudiant(@RequestBody EtudiantDto etudiantDto) {
        Etudiant etudiant = converter.dtoToEtudiant(etudiantDto);
        etudiant = service.saveEtudiant(etudiant);
        return converter.etudiantToDto(etudiant);
    }

    @PutMapping("/etudiants/{id}")
    public EtudiantDto updateEtudiant(@RequestBody EtudiantDto etudiantDto, @PathVariable Long id) {
        etudiantDto.setId(id);
        Etudiant etudiant = converter.dtoToEtudiant(etudiantDto);
        etudiant = service.saveEtudiant(etudiant);
        return converter.etudiantToDto(etudiant);
    }

    @Transactional
    @DeleteMapping("/etudiants/{id}")
    public void deleteetudiant(@PathVariable Long id) {
        service.deleteEtudiantById(id);
    }
}
