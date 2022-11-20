package ru.ruslanator.catalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruslanator.catalogservice.models.entites.Product;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Product, String> {
    List<Product> findBySku(String sku);
}
