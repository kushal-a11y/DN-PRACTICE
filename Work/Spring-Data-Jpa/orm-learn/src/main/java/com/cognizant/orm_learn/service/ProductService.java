package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> searchProducts(Map<String, Object> filters){
        return productRepository.searchProducts(filters);
    }
}
