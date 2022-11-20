package ru.ruslanator.productservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ruslanator.productservice.model.Product;

@FeignClient(name = "inventory-service", url = "localhost:8082")
public interface InventoryServiceFeignClient {
    @GetMapping("/{id}")
    Product getProduct(@PathVariable String id);
}
