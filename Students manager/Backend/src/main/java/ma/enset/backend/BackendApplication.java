package ma.enset.backend;

import ma.enset.backend.model.Etudiant;
import ma.enset.backend.model.Genre;
import ma.enset.backend.service.EtudiantSRV;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantSRV service) {
        return args -> {
            for (int i = 0; i < 20; i++) {
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Mohamed", "mohamed@gmail.com",
                        "https://picsum.photos/300/300",new Date(), Genre.M, true));
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Oussama", "oussama@gmail.com",
                        "https://picsum.photos/300/300",new Date(), Genre.M, true));
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Fatima", "fatima@gmail.com",
                        "https://picsum.photos/300/300",new Date(), Genre.F, true));
                service.saveEtudiant(new Etudiant(null, "ELYOUSFI", "Firdauosse", "firdauosse@gmail.com",
                        "https://picsum.photos/300/300",new Date(), Genre.F, true));
            }
        };
    }

}
