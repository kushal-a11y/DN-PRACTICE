package com.cognizant.orm_learn.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Product;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> searchProducts(Map<String, Object> filters){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq  = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if(filters.containsKey("ram")){
           predicates.add(cb.equal(product.get("ram"), filters.get("ram")));//adding condition1
        }
        if(filters.containsKey("hdd")){
            predicates.add(cb.greaterThanOrEqualTo(product.get("hdd"), (Integer)filters.get("hdd")));//adding condition2
        }
        if(filters.containsKey("cpu")){
            predicates.add(cb.equal(product.get("cpu"), filters.get("cpu")));
        }
        if(filters.containsKey("os")){
            predicates.add(cb.equal(product.get("os"), filters.get("os")));
        }
        if(filters.containsKey("weight")){
            predicates.add(cb.lessThanOrEqualTo(product.get("weight"), (Double)filters.get("weight")));
        }
        if(filters.containsKey("rating")){
            predicates.add(cb.greaterThanOrEqualTo(product.get("rating"), (Double)filters.get("rating")));
        }
        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(cq).getResultList();
    }
}
