package com.example.jpa_associations.repositories;

import com.example.jpa_associations.model.Consultation;
import com.example.jpa_associations.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
