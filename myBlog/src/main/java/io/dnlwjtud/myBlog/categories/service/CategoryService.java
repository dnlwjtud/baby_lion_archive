package io.dnlwjtud.myBlog.categories.service;

import io.dnlwjtud.myBlog.categories.dto.CategoryCurdDto;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.categories.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;


    // 카테고리 저장
    @Transactional
    public Category save(CategoryCurdDto editCategoryDto) {
        Category category = Category.createCategory(editCategoryDto);
        return categoryRepository.save(category);
    }

    // 카테고리 단건 조회(Optional)
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    // 카테고리 단건 조회
    public Category getByName(String name) {

        Optional<Category> categoryOptional = findByName(name);

        if ( categoryOptional.isPresent() ) {
            return categoryOptional.get();
        }

        return null;

    }

    // 카테고리 목록
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // 카테고리 수정
    @Transactional
    public Category update(String originName, CategoryCurdDto editCategoryDto) {

        Category findCategory = getByName(originName);

        if ( findCategory == null ) {
            return null;
        }

        return findCategory.update(editCategoryDto);

    }

    // 카테고리 삭제
    @Transactional
    public void remove(CategoryCurdDto editCategoryDto) {

        Category findCategory = getByName(editCategoryDto.getName());

        if ( findCategory == null ) {
            return;
        }

        categoryRepository.delete(findCategory);

    }

}
