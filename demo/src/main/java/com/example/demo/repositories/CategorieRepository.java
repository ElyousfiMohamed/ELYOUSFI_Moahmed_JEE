package com.example.demo.repositories;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,String> {
    List<Categorie> findAll();
}
