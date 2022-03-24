package com.example.tp3mvcpatients;

import com.example.tp3mvcpatients.entities.Patient;
import com.example.tp3mvcpatients.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Tp3MvcPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp3MvcPatientsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return  args -> {
            for (int i = 0;i<20;i++) {
                patientRepository.save(new Patient(null,"Hassan", LocalDate.now().toString(),false,12));
                patientRepository.save(new Patient(null,"Mohamed",LocalDate.now().toString(),true,35));
                patientRepository.save(new Patient(null,"Oussama",LocalDate.now().toString(),false,98));
                patientRepository.save(new Patient(null,"Fatima",LocalDate.now().toString(),true,14));
            }

            //patientRepository.findAll().forEach(patient -> System.out.println(patient));
        };
    }
}
