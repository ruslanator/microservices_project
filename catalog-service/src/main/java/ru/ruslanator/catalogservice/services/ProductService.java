package ru.ruslanator.catalogservice.services;

import org.springframework.stereotype.Service;
import ru.ruslanator.catalogservice.entites.Product;
import ru.ruslanator.catalogservice.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(String id) {
        System.out.println(productRepository.findById(id));
        return productRepository.findById(id);
    }

    public List<Product> findBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
