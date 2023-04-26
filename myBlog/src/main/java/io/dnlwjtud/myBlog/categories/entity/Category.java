package io.dnlwjtud.myBlog.categories.entity;

import io.dnlwjtud.myBlog.categories.dto.CategoryCurdDto;
import io.dnlwjtud.myBlog.posts.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @OneToMany // (mappedBy = "category")
    private List<Post> postList = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Category createCategory(CategoryCurdDto createCategoryDto) {

        Category category = new Category();

        category.name = createCategoryDto.getName();
        category.code = createCategoryDto.getCode();

        return category;

    }

    public Category update(CategoryCurdDto editCategoryDto) {

        this.name = editCategoryDto.getName();
        this.code = editCategoryDto.getCode();

        this.updatedAt = LocalDateTime.now();

        return this;

    }

}
