package io.dnlwjtud.myBlog.global.controller;

import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class GlobalController {

    private final PostService postService;

    @GetMapping("/")
    public String getIndex(Model model) {

        List<Post> postList = postService.findAll();

        model.addAttribute("postList",postList);

        return "index";
    }

}
