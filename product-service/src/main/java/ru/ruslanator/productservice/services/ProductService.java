package ru.ruslanator.productservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ruslanator.productservice.model.Product;

@Service
public class ProductService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Product getProductCatalog(String id) {
        return restTemplate.getForObject("http://localhost:8081/catalog/{id}",
                Product.class, id);
    }

    public Product getProductInventory(String id) {
        return restTemplate.getForObject("http://localhost:8082/inventory/api/{id}",
                Product.class, id);
    }
}
