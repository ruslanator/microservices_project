package ru.ruslanator.catalogservice.entites;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Products")
public class Product {

    public Product() {
    }

    @Id
    @Column(name = "uniq_id")
    private String id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name_title")
    private String nameTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "list_price")
    private String listPrice;

    @Column(name = "sale_price")
    private String salePrice;

    @Column(name = "category")
    private String category;

    @Column(name = "category_tree")
    private String categoryTree;

    @Column(name = "average_product_rating")
    private String averageProductRating;

    @Column(name = "product_url")
    private String productUrl;

    @Column(name = "product_image_url")
    private String productImageUrl;

    @Column(name = "brand")
    private String brand;

    @Column(name = "total_number_reviews")
    private String totalNumberReviews;

    @Column(name = "reviews")
    private String reviews;

}