package com.example.blog.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(
        name = "post_table",
        uniqueConstraints = {@UniqueConstraint(columnNames = "title")}
)
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "post_id",
            nullable = false
    )
    private long id;
    @Column(
            name = "title",
            nullable = false
    )
    private String title;
    @Column(
            name = "description",
            nullable = false
    )
    private String description;
    @Column(
            name = "content",
            nullable = false
    )
    private String content;


}
