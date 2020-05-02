package com.shop.service;

import com.shop.persist.Product;
import com.shop.persist.ProductRepository;
import com.shop.persist.ProductRepr;
import com.shop.rest.ProductServiceRs;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "ru.geekbrains.service.ProductServiceWs", serviceName = "ProductService")
public class ProductServiceImpl implements ProductServiceRemote, ProductServiceLocal,
        ProductServiceWs, ProductServiceRs {

    @EJB
    private ProductRepository productRepository;

    @Override
    public void insert(ProductRepr product) {
        productRepository.insert(new Product(product.getId(), product.getName(),
                product.getDescription(), product.getPrice()));
    }

    @Override
    public void update(ProductRepr product) {
        productRepository.update(new Product(product.getId(), product.getName(),
                product.getDescription(), product.getPrice()));
    }

    @Override
    public void delete(long id) {
        productRepository.delete(id);
    }

    @Override
    public ProductRepr findById(long id) {
        Product product = productRepository.findById(id);
        return new ProductRepr(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }

    @Override
    public List<ProductRepr> findAll() {
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
