package ru.ruslanator.inventoryservice.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ruslanator.inventoryservice.clients.CatalogServiceFeignClient;
import ru.ruslanator.inventoryservice.models.dtos.ProductDTO;
import ru.ruslanator.inventoryservice.models.entities.Product;
import ru.ruslanator.inventoryservice.repositories.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepo;
    private final CatalogServiceFeignClient catalogServiceFeignClient;

    public Product getProduct(String id) {
        return convertToProduct(catalogServiceFeignClient.getProduct(id));
    }

    @Transactional
    public void saveProduct(Product product) {
        product.setInStock(true);
        inventoryRepo.save(product);
    }

    private Product convertToProduct(ProductDTO productDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(productDTO, Product.class);
    }
}
