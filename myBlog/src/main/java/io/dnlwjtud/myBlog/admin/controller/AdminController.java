package io.dnlwjtud.myBlog.admin.controller;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.admin.service.AdminService;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.posts.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adms")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/index") // /adms/index
    public String getAdminIndex(Model model) {
        Account findAccount = adminService.getAdmin();
        model.addAttribute("account", findAccount);
        return "/admin/admin_index";
    }

    @GetMapping("/posts")
    public String getPostPage(Model model) {
        List<Post> postList = adminService.getAllPost();
        model.addAttribute("postList", postList);
        return "/admin/admin_post";
    }

    @GetMapping("/categories")
    public String getCategoryPage(Model model) {
        List<Category> categoryList = adminService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "/admin/admin_category";
    }

}
