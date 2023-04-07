package io.dnlwjtud.myBlog.posts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PostController {

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }


}
