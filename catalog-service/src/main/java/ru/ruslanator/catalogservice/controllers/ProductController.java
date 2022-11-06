package ru.ruslanator.catalogservice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.catalogservice.dtos.ProductDTO;
import ru.ruslanator.catalogservice.entites.Product;
import ru.ruslanator.catalogservice.services.ProductService;
import ru.ruslanator.catalogservice.util.ProductErrorResponse;
import ru.ruslanator.catalogservice.util.ProductNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable String id) {
        return convertToProductDTO(productService.findOne(id));
    }


    @GetMapping("/sku/{sku}")
    public List<ProductDTO> getProductBySku(@PathVariable String sku) {
        return productService.findBySku(sku).stream().map(this::convertToProductDTO)
                .collect(Collectors.toList());
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
