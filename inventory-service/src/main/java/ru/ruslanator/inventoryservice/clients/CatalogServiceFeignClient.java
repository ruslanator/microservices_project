package ru.ruslanator.inventoryservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ruslanator.inventoryservice.models.dtos.ProductDTO;

@FeignClient(name = "catalog-service", url = "localhost:8081")
public interface CatalogServiceFeignClient {
    @GetMapping("/catalog/{id}")
    ProductDTO getProduct(@PathVariable String id);
}
