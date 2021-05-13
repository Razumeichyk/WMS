package com.example.wms.controllers;

import com.example.wms.entities.Supplier;
import com.example.wms.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/suppliers")
public class SupplierRestController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/add")
    public Supplier createNewSupplier(@RequestBody Supplier supplier){
        return supplierService.createNewSupplier(supplier);
    }
}
