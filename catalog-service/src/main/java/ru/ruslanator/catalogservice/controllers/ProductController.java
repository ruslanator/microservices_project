package ru.ruslanator.catalogservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ruslanator.catalogservice.entites.Product;
import ru.ruslanator.catalogservice.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping("/sku/{sku}")
    public List<Product> getProductBySku(@PathVariable String sku) {
        return productService.findBySku(sku);
    }
}
