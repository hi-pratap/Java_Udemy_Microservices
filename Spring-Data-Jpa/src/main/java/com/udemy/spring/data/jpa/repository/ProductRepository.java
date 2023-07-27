package com.udemy.spring.data.jpa.repository;

import com.udemy.spring.data.jpa.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {


    Products findByName(String name);

    @Override
    Optional<Products> findById(Long aLong);

    /*
  >> Write a query method to find or retrieve a product by name and description
    select * from products where name = "product 1" and description = "product 1 desc";
     */
    List<Products> findByNameOrDescription(String name, String description);

    /*
    >> Write a query method to find or retrieve a product by name and description
    select * from products where name = "product 1" and description = "product 1 desc";
     */
    List<Products> findByNameAndDescription(String name, String description);

    Products findDistinctByName(String name);

    List<Products> findByPriceGreaterThan(BigDecimal price);
    List<Products> findByPriceLessThan(BigDecimal price);
    List<Products> findByNameContaining(String name);

    List<Products> findByNameLike(String apple);

    List<Products> findByPriceBetween(BigDecimal one, BigDecimal two);
    List<Products> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Products> findFirst2ByOrderByNameAsc();
    List<Products> findTop3ByOrderByPriceDesc();
}
