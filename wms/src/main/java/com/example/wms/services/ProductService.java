package com.example.wms.services;

import com.example.wms.entities.Product;
import com.example.wms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name){
        return productRepository.findProductByName(name);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
}
