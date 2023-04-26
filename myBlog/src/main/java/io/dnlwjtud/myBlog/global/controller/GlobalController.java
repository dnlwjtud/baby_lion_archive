package io.dnlwjtud.myBlog.global.controller;

import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class GlobalController {

    private final PostService postService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String getIndex(Model model, @RequestParam(value = "category", defaultValue = "all") String categoryName) {

        if ( categoryName.equals("all") ) {
            List<Post> postList = postService.findAll();
            model.addAttribute("postList", postList);
        } else {
            
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "index";
    }

    @GetMapping("/admin/test")
    public String getTestPage() {
        return "/admin/admin_index";
    }

}
