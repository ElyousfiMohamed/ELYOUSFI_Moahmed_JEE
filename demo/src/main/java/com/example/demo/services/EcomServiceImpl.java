package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Product;
import com.example.demo.mappers.CatalogMappers;
import com.example.demo.repositories.CategorieRepository;
import com.example.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EcomServiceImpl implements EcomService {
    ProductRepository productRepository;
    CategorieRepository categorieRepository;
    CatalogMappers catalogMapper;

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteProductById(id);
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = catalogMapper.fromProductDTO(productDTO);
        Product savedProduct = productRepository.save(product);
        return catalogMapper.fromProduct(savedProduct);
    }

    public List<ProductDTO> producList() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(
                product -> catalogMapper.fromProduct(product))
                .collect(Collectors.toList());
        return productDTOS;
    }
}
