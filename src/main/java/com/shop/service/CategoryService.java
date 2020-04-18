package com.shop.service;

import com.shop.persist.CategoryRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    @Transactional
    public List<CategoryRepr> findAll() {
       return categoryRepository.findAll().stream()
                .map(CategoryRepr::new)
                .collect(Collectors.toList());

    }
}
