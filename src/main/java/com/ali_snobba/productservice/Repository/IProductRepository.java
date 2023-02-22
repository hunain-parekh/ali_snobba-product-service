package com.ali_snobba.productservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ali_snobba.productservice.Model.Product;

public interface IProductRepository extends JpaRepository<Product,Long>{
    
}
