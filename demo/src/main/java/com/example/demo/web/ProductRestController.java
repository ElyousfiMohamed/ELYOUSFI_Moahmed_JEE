package com.example.demo.web;

import com.example.demo.entities.*;
import com.example.demo.services.*;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductRestController {
    private EcomService ecomService;

    @GetMapping("/products")
    public List<Product> productsList() {
        return ecomService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product product(@PathVariable(name = "id") String id) {
        return ecomService.findProductById(id);
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return ecomService.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable String id) {
        product.setId(id);
        return ecomService.saveProduct(product);
    }

    @Transactional
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        ecomService.deleteProductById(id);
    }
}
