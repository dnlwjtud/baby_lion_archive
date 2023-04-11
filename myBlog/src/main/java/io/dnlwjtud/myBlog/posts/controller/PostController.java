package io.dnlwjtud.myBlog.posts.controller;

import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/write")
    public String getPostWriteView() {
        return "/posts/post_write";
    }

    @PostMapping("/posts/write")
    public String postWrite(
            String title, String body
    ) {
        Long savedId = postService.save(title, body);
        return "redirect:/";
    }

    @GetMapping("/posts/{id}")
    public String getPost(
            @PathVariable Long id,
            Model model
    ) {
        Post findPost = postService.getById(id);

        model.addAttribute("post", findPost); // Map<String, Object>
        return "/posts/post_detail";
    }

    @GetMapping("/posts/test")
    public String testPage() {
        return "/tmp/4xx";
    }


}

