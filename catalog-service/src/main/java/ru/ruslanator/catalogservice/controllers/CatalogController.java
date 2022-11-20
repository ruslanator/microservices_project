package ru.ruslanator.catalogservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.catalogservice.exceptiions.ProductNotFoundException;
import ru.ruslanator.catalogservice.models.dtos.ProductDTO;
import ru.ruslanator.catalogservice.models.dtos.ProductErrorResponse;
import ru.ruslanator.catalogservice.models.entites.Product;
import ru.ruslanator.catalogservice.services.CatalogService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService productService;

    @Value("${test}")
    private String test;

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable String id) {
        log.debug("Get product with id: " + id);
        return convertToProductDTO(productService.findOne(id));
    }

    @GetMapping("/sku/{sku}")
    public List<ProductDTO> getProductBySku(@PathVariable String sku) {
        log.debug("Get product with sku: " + sku);
        return productService.findBySku(sku).stream().map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/test")
    public String test() {
        log.debug("test " + this.test);
        return this.test;
    }

    private ProductDTO convertToProductDTO(Product product) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductDTO.class);
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        ProductErrorResponse response = new ProductErrorResponse(
                "Product with this id wasn't found",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
