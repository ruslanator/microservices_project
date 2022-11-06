package ru.ruslanator.catalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ruslanator.catalogservice.dtos.ProductDTO;
import ru.ruslanator.catalogservice.entites.Product;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Product, String> {

    List<Product> findBySku(String sku);
}
