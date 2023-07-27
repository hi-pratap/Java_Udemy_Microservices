package com.udemy.spring.data.jpa.repository;

import com.udemy.spring.data.jpa.entity.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Products products = new Products();
        products.setName("Apple");
        products.setDescription("Mobile");
        products.setPrice(new BigDecimal(100));
        products.setActive(true);
        products.setImageUrl("http://www.google.com");
        products.setSku("sku");
        //save Product
        Products savedProduct = productRepository.save(products);

        //display Produxt
        System.out.println(savedProduct.toString());

    }

    @Test
    void updateUsingSave() {
        long id = 1l;
        Products exsitingProduct =
                productRepository.findById(id).get();

        exsitingProduct.setName("Nokia");
        exsitingProduct.setSku("kjsadhajshdkasjhfkj");

        productRepository.save(exsitingProduct);

        System.out.println(exsitingProduct.toString());
    }

    @Test
    void findByIdMethod() {
        long id = 1l;
        Products exsitingProduct =
                productRepository.findById(id).get();
        System.out.println(exsitingProduct.toString());
    }

    @Test
    void saveAllMethod() {
        Products products = new Products();
        products.setName("Apqwwrtple");
        products.setDescription("Mobile");
        products.setPrice(new BigDecimal(100));
        products.setActive(true);
        products.setImageUrl("http://www.google.com");
        products.setSku("sku4");
        Products products2 = new Products();
        products2.setName("qwer");
        products2.setDescription("Mobile");
        products2.setPrice(new BigDecimal(200));
        products2.setActive(true);
        products2.setImageUrl("http://www.google.com");
        products2.setSku("sku5");
        //save Product
        Products products3 = new Products();
        products3.setName("sdfsqwerdf");
        products3.setDescription("Mobile");
        products3.setPrice(new BigDecimal(300));
        products3.setActive(true);
        products3.setImageUrl("http://www.google.com");
        products3.setSku("skus6");
        //save Product

        productRepository.saveAll(List.of(products, products2, products3));


    }
    @Test
    void findAll(){
        List<Products> all = productRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void deleteMethod(){
        Optional<Products> byId = productRepository.findById(1l);
        Products products = byId.get();
        productRepository.delete(products);
    }

    @Test
    void deleteAll(){
        productRepository.deleteAll();
    }

    @Test
    void count(){
        long count = productRepository.count();
        System.out.println(count);
    }
    @Test
    void existByID(){
        boolean b = productRepository.existsById(1l);
        System.out.println(b);
    }
}