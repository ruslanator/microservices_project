package ru.ruslanator.catalogservice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ruslanator.catalogservice.entites.Product;
import ru.ruslanator.catalogservice.repositories.ProductRepository;
import ru.ruslanator.catalogservice.services.ProductService;

@SpringBootApplication
@EnableBatchProcessing
public class CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }


}
