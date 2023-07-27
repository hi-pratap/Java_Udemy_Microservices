package com.udemy.spring.data.jpa.repository;

import com.udemy.spring.data.jpa.entity.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        String name = "Apple";
        Products byName = productRepository.findByName(name);
        System.out.println(byName);

    }

    @Test
    void findByIdMethod() {

        Optional<Products> byName = productRepository.findById(1l);
        System.out.println(byName.get());

    }

    @Test
    void findByNameOrDesc() {
        List<Products> byNameOrDescription = productRepository.findByNameOrDescription("Apple", "null");
        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findAndNameOrDesc() {
        List<Products> byNameOrDescription = productRepository.findByNameAndDescription("Apple", "Mobile");
        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findDistinctByName() {
        Products byNameOrDescription = productRepository.findDistinctByName("Apple");
        System.out.println(byNameOrDescription);
    }

    @Test
    void findByPriceGreaterThan() {
        List<Products> byNameOrDescription = productRepository.findByPriceGreaterThan(new BigDecimal(1));

        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findByPriceLessThan() {
        List<Products> byNameOrDescription = productRepository.findByPriceLessThan(new BigDecimal(200));

        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findByNameContaining() {
        List<Products> byNameOrDescription = productRepository.findByNameContaining("Apple");

        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findByNameLike() {
        List<Products> byNameOrDescription = productRepository.findByNameLike("Apple");

        byNameOrDescription.stream().forEach(System.out::println);
    }


    @Test
    void findByPriceBetween() {
        List<Products> byNameOrDescription = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));

        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findByDateBetween() {
        List<Products> byNameOrDescription = productRepository.findByDateCreatedBetween(LocalDateTime.of(2021, 07, 19, 10, 10), LocalDateTime.of(2023, 07, 19, 10, 10));

        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findFirst2() {
        List<Products> byNameOrDescription = productRepository.findFirst2ByOrderByNameAsc();

        byNameOrDescription.stream().forEach(System.out::println);
    }

    @Test
    void findTop3() {
        List<Products> byNameOrDescription = productRepository.findTop3ByOrderByPriceDesc();

        byNameOrDescription.stream().forEach(System.out::println);
    }


}
