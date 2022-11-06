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
    private String getProduct(@PathVariable String id) {
        Product newProduct = inventoryService.getProduct(id);
        newProduct.setInStock(true);
        inventoryService.saveProduct(newProduct);
        return "Product with ID = " + newProduct.getId()
                + " in stock.";
    }
}
