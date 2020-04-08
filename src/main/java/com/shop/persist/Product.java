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

//    public ArrayList<Product> getProduct() {
//        ArrayList<Product> prodList = new ArrayList<Product>();
//
//        prodList.add(new Product(1, "Product1", "Desc1", null));
//        prodList.add(new Product(2, "Product2", "Desc2", null));
//        prodList.add(new Product(3, "Product3", "Desc3", null));
//        prodList.add(new Product(4, "Product4", "Desc4", null));
//        prodList.add(new Product(5, "Product5", "Desc5", null));
//        prodList.add(new Product(6, "Product6", "Desc6", null));
//        prodList.add(new Product(7, "Product7", "Desc7", null));
//        prodList.add(new Product(8, "Product8", "Desc8", null));
//        prodList.add(new Product(9, "Product9", "Desc9", null));
//
//        for (Product prod : prodList)
//        {
//            System.out.print("ID, Name Description and Price: ");
//            System.out.println(prod.productId + " " + prod.name + " " + prod.description + " " + prod.price);
//        }
//        return prodList;
//    }
}