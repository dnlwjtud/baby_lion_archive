package io.dnlwjtud.myBlog.posts.controller;

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
        System.out.println("title = " + title);
        System.out.println("body = " + body);

        Long savedId = postService.save(title, body);

        System.out.println("savedId = " + savedId);

        return "redirect:/";
    }

    // Spring MVC
    // Spring 요청 - 응답 흐름
    // Request -> Controller -> Service -> Repository -> Service -> Controller -> Response
    // HTTP Method¡
    // GET, POST



}
