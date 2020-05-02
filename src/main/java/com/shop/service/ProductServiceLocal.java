package com.shop.service;

import com.shop.persist.ProductRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductServiceLocal {

    void insert(ProductRepr product);

    void update(ProductRepr product);

    void delete(long id);

    ProductRepr findById(long id);

    List<ProductRepr> findAll();

}
