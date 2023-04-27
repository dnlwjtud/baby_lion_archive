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

    @Transactional
    public void categoryInit() {

        // 카테고리 10개 생성
        for ( int i = 1; i < 11; i++ ) {

            // 10회 save()

            Category category = Category.createCategory(
                    new CategoryCurdDto("카테고리 " + i, "category_" + i)
            );

            categoryRepository.save(category);

        }

    }


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

    public Category getByCode(String code) {
        return categoryRepository.getByCode(code);
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
