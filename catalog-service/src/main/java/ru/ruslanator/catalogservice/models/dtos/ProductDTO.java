package ru.ruslanator.catalogservice.models.dtos;

import lombok.Data;

@Data
public class ProductDTO {

    private String id;
    private String sku;
    private String nameTitle;
    private String description;
    private String listPrice;
    private String salePrice;
    private String category;
    private String categoryTree;
    private String averageProductRating;
    private String productUrl;
    private String productImageUrl;
    private String brand;
    private String totalNumberReviews;
    private String reviews;
}
