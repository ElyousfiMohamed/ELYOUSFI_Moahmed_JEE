package com.example.demo.mappers;

import com.example.demo.dtos.CategorieDTO;
import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CatalogMappers {
    public ProductDTO fromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        productDTO.setCategorieDTO(fromCategorie(product.getCategorie()));
        return productDTO;
    }

    public Product fromProductDTO(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setCategorie(fromCategorieDTO(productDTO.getCategorieDTO()));
        return product;
    }

    public CategorieDTO fromCategorie(Categorie categorie) {
        CategorieDTO categorieDTO = new CategorieDTO();
        BeanUtils.copyProperties(categorie,categorieDTO);
        return categorieDTO;
    }

    public Categorie fromCategorieDTO(CategorieDTO categorieDTO) {
        Categorie categorie = new Categorie();
        BeanUtils.copyProperties(categorieDTO,categorie);
        return categorie;
    }
}
