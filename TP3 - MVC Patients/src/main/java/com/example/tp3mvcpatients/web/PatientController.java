package com.example.tp3mvcpatients.web;

import com.example.tp3mvcpatients.entities.Patient;
import com.example.tp3mvcpatients.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
                                        @RequestParam(name = "size",defaultValue = "5")int size) {
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page, size) );
        model.addAttribute("list",patients.getContent());
        model.addAttribute("nbrPages",new int[patients.getTotalPages()]);
        model.addAttribute("pagecourant",page);
        return "patients";
    }
}
