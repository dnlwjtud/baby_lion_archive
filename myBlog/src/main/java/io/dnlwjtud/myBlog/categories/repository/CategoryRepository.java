package io.dnlwjtud.myBlog.categories.repository;

import io.dnlwjtud.myBlog.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
    Category getByCode(String code);

}
