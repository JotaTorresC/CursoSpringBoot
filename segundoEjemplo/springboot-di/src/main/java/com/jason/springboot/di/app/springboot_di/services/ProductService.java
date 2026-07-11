package com.jason.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;
import com.jason.springboot.di.app.springboot_di.model.Product;
import com.jason.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        
        return repository.findAll().stream().map(p -> {

            Double priceTax = p.getPrice() * 1.25d;
            //Product nweProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product nweProduct = (Product) p.clone();
            nweProduct.setPrice(priceTax.longValue());
            return nweProduct;

        }).collect(Collectors.toList()); //asi es como se convierte un stream a una lista collect(Collectors.toList())
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
