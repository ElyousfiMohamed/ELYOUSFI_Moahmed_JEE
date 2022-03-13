package com.example.jpa_associations.metier;

import com.example.jpa_associations.model.Consultation;
import com.example.jpa_associations.model.Medecin;
import com.example.jpa_associations.model.Patient;
import com.example.jpa_associations.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRendezVous(RendezVous rendezVous);
}
