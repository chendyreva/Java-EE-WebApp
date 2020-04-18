package com.shop.service;

import com.shop.persist.ProductRepositoryImpl;

import javax.inject.Inject;
import javax.transaction.*;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    @Inject
    private ProductRepositoryImpl productRepository;


    @Transactional
    public List<ProductRepr> findAll() {
    return productRepository.findAll().stream()
                .map(ProductRepr::new)
                .collect(Collectors.toList());
    }
}

