package ru.ruslanator.inventoryservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.inventoryservice.models.entities.Product;
import ru.ruslanator.inventoryservice.services.InventoryService;


@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    private Product getProduct(@PathVariable String id) {
        Product newProduct = inventoryService.getProduct(id);
        inventoryService.saveProduct(newProduct);
        return newProduct;
    }
}
