package com.shop.persist;

import javax.ejb.Remote;
import java.util.List;
import java.util.concurrent.Future;

@Remote
public interface ProductServiceRemote {

     List<ProductRepr> findAll();

     Future<List<ProductRepr>> findAllAsync();
}
