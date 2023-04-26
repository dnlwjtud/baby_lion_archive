package io.dnlwjtud.myBlog.categories.entity;

import io.dnlwjtud.myBlog.categories.dto.CategoryCurdDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Category createCategory(CategoryCurdDto createCategoryDto) {

        Category category = new Category();

        category.name = createCategoryDto.getName();

        return category;

    }

    public Category update(CategoryCurdDto editCategoryDto) {

        this.name = editCategoryDto.getName();
        this.updatedAt = LocalDateTime.now();

        return this;

    }

}
