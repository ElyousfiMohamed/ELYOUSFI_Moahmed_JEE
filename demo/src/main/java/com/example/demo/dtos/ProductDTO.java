package com.example.demo.dtos;

import com.example.demo.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
        private String id;
        private String name;
        private double price;
        private double quantity;
        private CategorieDTO categorieDTO;
}
