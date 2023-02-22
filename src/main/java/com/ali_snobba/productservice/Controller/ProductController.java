package com.ali_snobba.productservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali_snobba.productservice.Model.Product;
import com.ali_snobba.productservice.Repository.IProductRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductRepository productRepo;

    @PostMapping
    public void saveProduct(Product product){
        productRepo.save(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    
}
