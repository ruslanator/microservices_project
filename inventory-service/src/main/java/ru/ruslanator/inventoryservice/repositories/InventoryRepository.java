package ru.ruslanator.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ruslanator.inventoryservice.entities.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product, String> {

}
