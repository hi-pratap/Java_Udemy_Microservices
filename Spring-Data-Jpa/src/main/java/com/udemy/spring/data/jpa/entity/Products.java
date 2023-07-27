package com.udemy.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                ), @UniqueConstraint(
                name = "name_unique",
                columnNames = "name"
        )
        })
public class Products {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1 // by increamenting one
    )
    private long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;

    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
