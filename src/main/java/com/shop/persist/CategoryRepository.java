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
import java.sql.SQLException;
import java.util.List;

@Stateless
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName ="ds")
    protected static EntityManager em;

    @Resource
    private UserTransaction ut;

    @PostConstruct
    public void init() throws SystemException, HeuristicRollbackException, HeuristicMixedException, RollbackException, SQLException {
        if(findAll().size() == 0) {
            try {
                ut.begin();
                insert(new Category(-1L, "Category1"));
                insert(new Category(-1L, "Category2"));
                insert(new Category(-1L, "Category3"));
            } catch (Exception e) {
                logger.error("", e);
                ut.rollback();
            }
            ut.commit();
        }
    }

    @TransactionAttribute
    public void insert(Category category)  {
        em.persist(category);
    }

    @TransactionAttribute
    public void update(Category category)  {
        em.merge(category);
    }

    @TransactionAttribute
    public void delete(long id) {

        Category category = em.find(Category.class, id);
        if(category != null) {
            em.remove(category);
        }
    }

    public Category findById(long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findAll()  {
        return em.createQuery( " from Category", Category.class).getResultList();
    }
}


