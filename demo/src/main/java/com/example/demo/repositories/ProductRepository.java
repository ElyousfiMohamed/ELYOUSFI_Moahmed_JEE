package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// @RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findProductById(String id);
    void deleteProductById(String id);
}
