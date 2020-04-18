package com.shop.persist;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

@Stateless
public class ProductRepositoryImpl  implements ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

   @PersistenceContext(unitName ="ds")
    protected static EntityManager em;

   @Resource
   private UserTransaction ut;

    @PostConstruct
    public void init() throws SystemException, HeuristicRollbackException, HeuristicMixedException, RollbackException, SQLException {
        if(findAll().size() == 0) {
        try {
            ut.begin();
            insert(new Product(-1L, "Product1", "Desc1", new BigDecimal(10)));
            insert(new Product(-1L, "Product2", "Desc2", new BigDecimal(102)));
            insert(new Product(-1L, "Product3", "Desc3", new BigDecimal(1030)));
        } catch (Exception e) {
            logger.error("", e);
            ut.rollback();
        }
        ut.commit();
    }
  }

    @Override
    @TransactionAttribute
    public void insert(Product product)  {
        em.persist(product);
    }

    @Override
    @TransactionAttribute
    public void update(Product product)  {
        em.merge(product);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {

        Product product = em.find(Product.class, id);
        if(product != null) {
            em.remove(product);
        }
    }

    @Override
    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll()  {
        return em.createQuery( " from Product", Product.class).getResultList();
    }
}
