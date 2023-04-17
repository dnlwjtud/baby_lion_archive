package io.dnlwjtud.myBlog.posts.controller;

import io.dnlwjtud.myBlog.posts.dto.PostWriteDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    public List<Post> getPostList() {
        List<Post> postList = postService.findAll();
        return postList;
    }

    @GetMapping("/write")
    public String getPostWriteView() {
        return "/posts/post_write";
    }

    @ResponseBody
    @PostMapping("/write")
    public PostWriteDto postWrite(
            @RequestBody @Valid PostWriteRequest postWriteRequest
    ) {

//        Long savedId = postService.save(postWriteRequest);
//        PostWriteDto postWriteDto = new PostWriteDto(savedId);

        return postService.save(postWriteRequest);

    }

    @GetMapping("/{id}")
    public String getPost(
            @PathVariable Long id,
            Model model
    ) {
        Post findPost = postService.getById(id);

        model.addAttribute("post", findPost); // Map<String, Object>
        return "/posts/post_detail";
    }

}

