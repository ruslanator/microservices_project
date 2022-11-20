package ru.ruslanator.catalogservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ruslanator.catalogservice.exceptiions.ProductNotFoundException;
import ru.ruslanator.catalogservice.models.entites.Product;
import ru.ruslanator.catalogservice.repositories.CatalogRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogRepository productRepository;

    public Product findOne(String id) {
        Optional<Product> foundPerson = productRepository.findById(id);
        return foundPerson.orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> findBySku(String sku) {
        return productRepository.findBySku(sku);
    }

}
