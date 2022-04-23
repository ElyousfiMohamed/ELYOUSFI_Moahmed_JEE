package com.example.demo;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Product;
import com.example.demo.services.EcomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(EcomService ecomService) {
        return args -> {
            Stream.of("Computers","Printers","Phones").forEach(c -> {
                Categorie categorie = new Categorie();
                categorie.setName(c);
                ecomService.saveCategorie(categorie);
            });

            ecomService.findAllCategories().forEach(categorie -> {
                Stream.of("Laptop1","Printer1","Phone1").forEach(p -> {
                    Product product = new Product();
                    product.setId(UUID.randomUUID().toString());
                    product.setName(p);
                    product.setPrice(Math.random()*5500+100);
                    product.setQuantity(Math.random()*100);
                    product.setCategorie(categorie);
                    ecomService.saveProduct(product);
                });
            });
        };
    }

}
