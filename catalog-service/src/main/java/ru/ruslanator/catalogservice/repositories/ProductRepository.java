package ru.ruslanator.catalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruslanator.catalogservice.entites.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findById(String id);

    List<Product> findBySku(String sku);
}
