package com.jason.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.jason.springboot.di.app.springboot_di.model.Product;

public interface IProductRepository {
    
    List<Product> findAll();

    Product findById(Long price);
}
