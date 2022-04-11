package com.example.activite_pratique_spring.web;

import com.example.activite_pratique_spring.entities.Etudiant;
import com.example.activite_pratique_spring.service.IServiceEtudiant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class EtudiantController {
    IServiceEtudiant service;

    @GetMapping("/")
    public String accueil() {
        return "redirect:/index";
    }

    @GetMapping(path = "/index")
    public String etudiants(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Etudiant> etudiants = service.findByPrenomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("etudiants", etudiants.getContent());
        model.addAttribute("nbrPages", new int[etudiants.getTotalPages()]);
        model.addAttribute("pagecourant", page);
        model.addAttribute("keyword", keyword);
        return "etudiants";
    }

    @GetMapping(path = "/admin/delete")
    public String supprimerEtudiant(Long id) {
        service.deleteEtudiantById(id);
        return "redirect:/index";
    }

    @GetMapping(path = "/admin/add")
    public String nouveauEtudiant(Model model) {
        model.addAttribute("etudiant",new Etudiant());
        return "add";
    }

    @PostMapping(path = "/admin/create")
    public String nouveau(Model model, @Valid Etudiant e, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  "add";
        }
        service.saveEtudiant(e);
        return "redirect:/index";
    }
}
