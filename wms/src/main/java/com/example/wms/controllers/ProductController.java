package com.example.wms.controllers;

import com.example.wms.entities.Product;
import com.example.wms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/web/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView getProducts() {
        List<Product> productList = productService.getProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productList);
        modelAndView.setViewName("product/productList");
        return modelAndView;
    }

    @GetMapping("/add")
    public String addProduct() {
        return "product/addProduct";
    }

    @PostMapping("/add")
    public ModelAndView addProduct(Product product) {
        productService.saveProduct(product);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/addProduct");
        return modelAndView;
    }

    @GetMapping("/update")
    public String updateProduct(ModelMap modelMap){
        modelMap.put("product", new Product());
        return "product/updateProduct";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product){
        productService.updateProduct(product);
        return "product/success";
    }

    @GetMapping("/delete")
    public String deleteProduct() {
        return "product/deleteProduct";
    }

    @PostMapping("/delete")
    public ModelAndView deleteProduct(Product product) {
        productService.deleteProduct(product);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/deleteProduct");
        return modelAndView;
    }

    @GetMapping("/id/{productId}")
    public ModelAndView getProductById(@PathVariable("productId") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/productView");
        modelAndView.addObject("product", productService.getProductById(id));
        return modelAndView;
    }

    @GetMapping("/name")
    public ModelAndView getProductByName(@RequestParam("productName") String name){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.getProductByName(name);
        modelAndView.addObject("products", productList);
        modelAndView.setViewName("product/productList");
        return modelAndView;
    }
}
