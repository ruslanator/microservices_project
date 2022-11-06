package ru.ruslanator.inventoryservice.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "inventory")
public class Product {

    @Id
    @Column(name = "inventory_id")
    private String id;

    @Column(name = "in_stock")
    private boolean inStock = true;

}
