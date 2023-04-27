package io.dnlwjtud.myBlog.admin.controller;

import io.dnlwjtud.myBlog.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adms")
public class AdminController {

    private final AdminService adminService;





}
