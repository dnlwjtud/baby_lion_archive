package io.dnlwjtud.myBlog.posts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PostController {

    @GetMapping("/posts/write")
    public String getPostWriteView() {
        return "/posts/post_write";
    }

}
