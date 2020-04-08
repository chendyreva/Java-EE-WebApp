package com.shop.persist;

import java.math.BigDecimal;
import java.util.*;

public class Product {


    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
 public Product() {

 }

    public Product(long productId, String name, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }
    public void setProductId(Long id) { this.productId = productId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}