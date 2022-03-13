package com.example.jpa_associations;

import com.example.jpa_associations.metier.IHospitalService;
import com.example.jpa_associations.model.*;
import com.example.jpa_associations.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaAssociationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAssociationsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Mohamed","Hassan","Najat").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);;
                patient.setDateDeNaissance(new Date());
                patient.setEmail(name+"@gmail.com");
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });

            Stream.of("Oussama","Mostapha","Firdaousse").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);;
                medecin.setSpecialite("Dentiste");
                medecin.setEmail(name+"@gmail.com");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient1 = patientRepository.findById(1L).orElse(null);
            Medecin medecin1 = medecinRepository.findById(1L).orElse(null);

            Patient patient2 = patientRepository.findByNom("Mohamed");
            Medecin medecin2 = medecinRepository.findByNom("Oussama");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin2);
            rendezVous.setPatient(patient2);
            hospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateDeConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport Consulation");
            hospitalService.saveConsultation(consultation);
        };
    }

}
