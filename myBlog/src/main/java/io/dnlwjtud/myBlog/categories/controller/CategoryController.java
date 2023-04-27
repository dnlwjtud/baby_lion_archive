package io.dnlwjtud.myBlog.categories.controller;

import io.dnlwjtud.myBlog.categories.dto.CategoryCurdDto;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/adms/categories/create")
    public String getCreateView() {
        return "/category/create_category";
    }

    @PostMapping("/adms/categories/create")
    public String createCategory(
            @Valid CategoryCurdDto categoryCurdDto
    ) {
        categoryService.save(categoryCurdDto);
        return "redirect:/adms/categories";
    }

    @GetMapping("/adms/categories/update")
    public String getUpdateView() {
        return "/category/create_category";
    }

    @PostMapping("/adms/categories/update")
    public String updateCategory(
            @RequestParam(value = "origin") String originCode,
            @Valid CategoryCurdDto categoryCurdDto
    ) {
        categoryService.update(originCode, categoryCurdDto);
        return "redirect:/adms/categories";
    }

    @GetMapping("/adms/categories/delete/{id}")
    public String removeCategory(
            @PathVariable(name = "id") Long id
    ) {
        categoryService.removeById(id);
        return "redirect:/";
    }

}
