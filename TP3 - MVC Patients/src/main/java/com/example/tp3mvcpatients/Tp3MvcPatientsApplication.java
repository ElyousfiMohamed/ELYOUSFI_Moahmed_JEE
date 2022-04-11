package com.example.tp3mvcpatients;

import com.example.tp3mvcpatients.entities.Patient;
import com.example.tp3mvcpatients.repositories.PatientRepository;
import com.example.tp3mvcpatients.security.service.IServiceSecurity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Tp3MvcPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp3MvcPatientsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository, IServiceSecurity iServiceSecurity){
        return  args -> {
            for (int i = 0;i<20;i++) {
                patientRepository.save(new Patient(null,"Hassan", new Date(),false,12));
                patientRepository.save(new Patient(null,"Mohamed",new Date(),true,35));
                patientRepository.save(new Patient(null,"Oussama",new Date(),false,98));
                patientRepository.save(new Patient(null,"Fatima",new Date(),true,14));
            }

            iServiceSecurity.saveNewUser("mohamed","1234","1234");
            iServiceSecurity.saveNewUser("fatima","1234","1234");
            iServiceSecurity.saveNewUser("oussama","1234","1234");

            iServiceSecurity.saveNewRole("USER","");
            iServiceSecurity.saveNewRole("ADMIN","");

            iServiceSecurity.addRoleToUser("mohamed","USER");
            iServiceSecurity.addRoleToUser("mohamed","ADMIN");

            iServiceSecurity.addRoleToUser("oussama","USER");

            iServiceSecurity.addRoleToUser("fatima","USER");

            //patientRepository.findAll().forEach(patient -> System.out.println(patient));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
