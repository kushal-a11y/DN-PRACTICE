package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.orm_learn.model.Stock;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;



public interface StockRepository extends JpaRepository<Stock, Integer>{
    List<Stock> findByDateBetweenAndCodeContaining(LocalDate startDate, LocalDate endDate, String text);  
    @Query(
        """
            SELECT s FROM Stock s 
            where (s.close) >= :price
        """
    )
    List<Stock> findStockByPriceGreaterThan(@Param("price") BigDecimal price);
}
