package ru.ruslanator.inventoryservice.models.dtos;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private boolean inStock = true;

}