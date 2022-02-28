package ma.enset.jpaap;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0;i<100;i++) {
            patientRepository.save(new Patient(null,"Mohamed",new Date(),false,5));
        }

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,10));

        System.out.println("Total pages : " + patients.getTotalPages());
        System.out.println("Total elements : " + patients.getTotalElements());
        System.out.println("Nombre des elements dans chaque page  : " + patients.getNumberOfElements());

        for (Patient p:patients) {
            System.out.println(p);
        }

        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,5));
        patientRepository.save(new Patient(null,"Oussama",new Date(),true,10));
        patientRepository.save(new Patient(null,"Firdaousse",new Date(),false,102));

        /*for (Patient p:patientRepository.findAll()) {
            System.out.println(p);
        }*/

        System.out.println("****************************************************");

        Patient patient = patientRepository.findById(1L).orElseThrow(()->new RuntimeException("Patient Not Found"));
        System.out.println(patient);

        System.out.println("****************************************************");

        patient.setScore(0);
        patientRepository.save(patient);
        System.out.println(patient = patientRepository.findById(1L).orElseThrow(()->new RuntimeException("Patient Not Found")));

        System.out.println("****************************************************");

        // List<Patient> patientList = patientRepository.findByMalade(false);

        /*for (Patient p:patientList) {
            System.out.println(p);
        }*/

        Page<Patient> patientList = patientRepository.findByMalade(false,PageRequest.of(0,4));
        for (Patient p:patientList) {
            System.out.println(p);
        }


    }
}
