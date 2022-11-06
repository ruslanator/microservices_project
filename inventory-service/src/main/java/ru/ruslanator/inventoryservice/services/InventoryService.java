package ru.ruslanator.inventoryservice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.ruslanator.inventoryservice.entities.Product;
import ru.ruslanator.inventoryservice.repositories.InventoryRepository;

@Service
public class InventoryService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final InventoryRepository inventoryRepo;

    public InventoryService(InventoryRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public Product getProduct(String id) {
        return restTemplate.getForObject("http://localhost:8081/catalog/{id}",
                Product.class, id);
    }

    @Transactional
    public void saveProduct(Product product) {
        inventoryRepo.save(product);
    }
}
