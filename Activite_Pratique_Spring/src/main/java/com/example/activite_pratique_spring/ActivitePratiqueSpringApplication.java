package com.example.activite_pratique_spring;

import com.example.activite_pratique_spring.entities.Etudiant;
import com.example.activite_pratique_spring.entities.Genre;
import com.example.activite_pratique_spring.security.service.IServiceSecurity;
import com.example.activite_pratique_spring.service.IServiceEtudiant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ActivitePratiqueSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitePratiqueSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IServiceEtudiant service, IServiceSecurity serviceSeurity) {
        return args -> {
            for (int i = 0; i < 20; i++) {
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Mohamed", "mohamed@gmail.com", new Date(), Genre.M, true));
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Oussama", "oussama@gmail.com", new Date(), Genre.M, true));
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Fatima", "fatima@gmail.com", new Date(), Genre.F, true));
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Firdauosse", "firdauosse@gmail.com", new Date(), Genre.F, true));
            }

            serviceSeurity.saveNewUser("mohamed", "1234", "1234");
            serviceSeurity.saveNewUser("fatima", "1234", "1234");
            serviceSeurity.saveNewUser("oussama", "1234", "1234");

            serviceSeurity.saveNewRole("USER", "");
            serviceSeurity.saveNewRole("ADMIN", "");

            serviceSeurity.addRoleToUser("mohamed", "USER");
            serviceSeurity.addRoleToUser("mohamed", "ADMIN");
            serviceSeurity.addRoleToUser("oussama", "USER");
            serviceSeurity.addRoleToUser("fatima", "USER");
        };
    }
}
