package com.example.wms.services;

import com.example.wms.entities.Product;
import com.example.wms.entities.Supplier;
import com.example.wms.repositories.ProductRepository;
import com.example.wms.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier createNewSupplier(Supplier supplier){
        for (Product product : supplier.getDeliveredProducts()){
            productRepository.save(product);
        }
        return supplierRepository.save(supplier);
    }
}
