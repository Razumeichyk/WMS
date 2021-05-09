package com.example.wms.controllers;

import com.example.wms.entities.Product;
import com.example.wms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getStudents() {
        return productService.getProducts();
    }

    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{productName}")
    public List<Product> getProductByName(@PathVariable("productName") String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

//    @GetMapping("/retrieve/{id}")
//    public Product retrieveProduct(@PathVariable Long id) {
//        Product product = productService.getProductById(id);
//        if (product == null)
//            throw new EntityNotFoundException("id: " + id);
//        return product;
//
//    }
}
