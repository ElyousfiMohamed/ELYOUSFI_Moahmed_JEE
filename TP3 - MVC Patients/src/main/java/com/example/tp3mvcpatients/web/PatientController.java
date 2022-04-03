package com.example.tp3mvcpatients.web;

import com.example.tp3mvcpatients.entities.Patient;
import com.example.tp3mvcpatients.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PatientController {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping(path = "/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("list", patients.getContent());
        model.addAttribute("nbrPages", new int[patients.getTotalPages()]);
        model.addAttribute("pagecourant", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping(path = "/admin/delete")
    public String delete(Long id) {
        patientRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping(path = "/admin/new")
    public String nouveau(Model model) {
        model.addAttribute("patient",new Patient());
        return "ajout";
    }

    @PostMapping(path = "/admin/create")
    public String nouveau(Model model, @Valid Patient p, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  "ajout";
        }
        patientRepository.save(p);
        return "redirect:/index";
    }

    @PostMapping(path = "/admin/maj")
    public String maj(Model model, @Valid Patient p, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  "modification";
        }
        patientRepository.save(p);
        return "redirect:/index";
    }

    @GetMapping(path = "/admin/update")
    public String update(Model model, Long id) {
        Patient p = patientRepository.findPatientById(id);
        model.addAttribute("patient",p);
        return "modification";
    }
}
