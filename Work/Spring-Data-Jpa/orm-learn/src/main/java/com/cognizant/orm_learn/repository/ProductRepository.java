package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm_learn.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>, ProductRepositoryCustom{
}
