package com.shop.persist;


import com.shop.service.ProductRepr;


import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Stateless
public class ProductRepositoryImpl implements ProductServiceRemote {
    @EJB
    private ProductRepository productRepository;

    @Override
    public List<ProductRepr> findAll() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productRepository.findAll().stream()
                .map(p -> new ProductRepr(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .collect(Collectors.toList());
    }


    @Asynchronous
    @Override
    public Future<List<ProductRepr>> findAllAsync() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(findAll());
    }
}