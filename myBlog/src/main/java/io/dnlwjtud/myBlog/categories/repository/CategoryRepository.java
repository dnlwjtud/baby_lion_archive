package io.dnlwjtud.myBlog.categories.repository;

import io.dnlwjtud.myBlog.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
