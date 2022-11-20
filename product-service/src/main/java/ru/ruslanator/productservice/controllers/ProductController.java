package ru.ruslanator.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ruslanator.productservice.model.Product;
import ru.ruslanator.productservice.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String checkProduct(@PathVariable String id) {

        Product productFromCatalog = productService.getProductCatalog(id);
        Product productFromInventory = productService.getProductInventory(id);

        if(productFromCatalog.getId().equals(productFromInventory.getId())) {
            return "Product available in catalog and inventory.";
        }

        return "Product not found";

    }
}
