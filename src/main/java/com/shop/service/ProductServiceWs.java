package com.shop.service;

import com.shop.persist.ProductRepr;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {

    @WebMethod
    ProductRepr findById(long id);

    @WebMethod
    List<ProductRepr> findAll();
}
