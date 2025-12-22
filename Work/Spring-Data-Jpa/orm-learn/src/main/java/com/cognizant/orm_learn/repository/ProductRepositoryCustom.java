package com.cognizant.orm_learn.repository;

import java.util.List;
import java.util.Map;
import com.cognizant.orm_learn.model.Product;

public interface ProductRepositoryCustom {
    List<Product> searchProducts(Map<String, Object> filters);
}
