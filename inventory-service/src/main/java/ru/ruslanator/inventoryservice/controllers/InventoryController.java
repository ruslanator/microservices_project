package ru.ruslanator.inventoryservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.ruslanator.inventoryservice.entities.Product;
import ru.ruslanator.inventoryservice.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{id}")
    private Product getProduct(@PathVariable String id) {
        Product newProduct = inventoryService.getProduct(id);
        newProduct.setInStock(true);
        inventoryService.saveProduct(newProduct);
        return newProduct;
    }

    @GetMapping("/api/{id}")
    private Product getProduct2(@PathVariable String id) {
        return inventoryService.getProduct(id);
    }
}
