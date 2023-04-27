package io.dnlwjtud.myBlog.admin.controller;

import io.dnlwjtud.myBlog.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adms")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/index")
    public String getAdminIndex() {
        return "/admin/admin_index";
    }

    @GetMapping("/posts")
    public String getPostPage(Model model) {
        model.addAttribute("postList", adminService.getAllPost());
        return "/admin/admin_post";
    }


}
