package io.dnlwjtud.myBlog.categories.controller;

import io.dnlwjtud.myBlog.categories.dto.CategoryCurdDto;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/adms/categories/update/{categoryCode}")
    public String getUpdateView(
            @PathVariable(name = "categoryCode") String categoryCode,
            Model model
    ) {
        Category findCategory = categoryService.getByCode(categoryCode);
        model.addAttribute("category", findCategory);
        return "/category/update_category";
    }

    @PostMapping("/adms/categories/update/{categoryCode}")
    public String updateCategory(
            @PathVariable(name = "categoryCode") String categoryCode,
            @Valid CategoryCurdDto categoryCurdDto
    ) {
        categoryService.update(categoryCode, categoryCurdDto);
        return "redirect:/adms/categories";
    }

    @GetMapping("/adms/categories/delete/{id}")
    public String removeCategory(
            @PathVariable(name = "id") Long id
    ) {
        categoryService.removeById(id);
        return "redirect:/adms/categories";
    }

}
