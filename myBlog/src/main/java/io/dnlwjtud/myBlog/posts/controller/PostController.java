package io.dnlwjtud.myBlog.posts.controller;

import io.dnlwjtud.myBlog.posts.dto.PostUpdateDto;
import io.dnlwjtud.myBlog.posts.dto.PostEditDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PostEditDto postWrite(
            @RequestBody @Valid PostWriteRequest postWriteRequest
    ) {
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

    @GetMapping("/update/{id}")
    public String getUpdateView(
            @PathVariable Long id,
            Model model
    ) {
        Post findPost = postService.getById(id);
        model.addAttribute("post", findPost);
        return "/posts/post_update";
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public PostEditDto updatePost(
            @PathVariable Long id,
            @RequestBody @Valid PostUpdateDto postUpdateDto
    ) {
        return postService.updateById(id, postUpdateDto);
    }

}

