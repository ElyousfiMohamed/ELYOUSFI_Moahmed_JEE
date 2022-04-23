package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Product;

import java.util.List;

public interface EcomService {
    Product saveProduct(Product product);
    Categorie saveCategorie(Categorie categorie);
    List<Product> findAllProducts();
    List<Categorie> findAllCategories();
    Product findProductById(String id);
    void deleteProductById(String id);
}
