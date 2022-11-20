package ru.ruslanator.productservice.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.clients.CatalogServiceFeignClient;
import ru.ruslanator.productservice.clients.InventoryServiceFeignClient;
import ru.ruslanator.productservice.model.Product;
import ru.ruslanator.productservice.model.ProductDTO;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CatalogServiceFeignClient catalogServiceFeignClient;
    private final InventoryServiceFeignClient inventoryServiceFeignClient;

    public Product getProductCatalog(String id) {
        return convertToProduct(catalogServiceFeignClient.getProduct(id));
    }

    public Product getProductInventory(String id) {
        return inventoryServiceFeignClient.getProduct(id);
    }

    private Product convertToProduct(ProductDTO productDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(productDTO, Product.class);
    }
}
