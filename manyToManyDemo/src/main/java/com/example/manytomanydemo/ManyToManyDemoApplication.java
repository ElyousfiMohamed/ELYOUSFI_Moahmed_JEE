package com.example.manytomanydemo;

import com.example.manytomanydemo.entities.Role;
import com.example.manytomanydemo.entities.User;
import com.example.manytomanydemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.stream.Stream;

@Configuration
@SpringBootApplication
@EnableScheduling
public class ManyToManyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService) {
        return args -> {
            User u1 = new User();
            u1.setUserName("simo");
            u1.setPassword("04052000");
            userService.addNewUser(u1);

            User u2 = new User();
            u2.setUserName("ouss");
            u2.setPassword("10012010");
            userService.addNewUser(u2);

            Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                Role r1 = new Role();
                r1.setRoleName(r);
                userService.addNewRole(r1);
            });

            userService.addRoleToUser(u1.getUserName(),"STUDENT");
            userService.addRoleToUser(u1.getUserName(),"USER");
            userService.addRoleToUser(u2.getUserName(),"ADMIN");
            userService.addRoleToUser(u2.getUserName(),"USER");
        };
    }

}
