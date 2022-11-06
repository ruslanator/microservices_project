package ru.ruslanator.catalogservice.services;

import org.springframework.stereotype.Service;
import ru.ruslanator.catalogservice.entites.Product;
import ru.ruslanator.catalogservice.repositories.ProductRepository;
import ru.ruslanator.catalogservice.util.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findOne(String id) {
        Optional<Product> foundPerson = productRepository.findById(id);
        return foundPerson.orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> findBySku(String sku) {
        return productRepository.findBySku(sku);
    }

}
