package com.jason.springboot.di.app.springboot_di.services;

import java.util.List;

import com.jason.springboot.di.app.springboot_di.model.Product;

public interface IProductService {
    
     public List<Product> findAll();

     public Product findById(Long id);

}
