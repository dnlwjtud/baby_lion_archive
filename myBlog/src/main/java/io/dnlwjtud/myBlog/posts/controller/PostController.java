package io.dnlwjtud.myBlog.posts.controller;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import io.dnlwjtud.myBlog.posts.dto.PostUpdateDto;
import io.dnlwjtud.myBlog.posts.dto.PostEditDto;
import io.dnlwjtud.myBlog.posts.dto.PostWriteRequest;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;

    @GetMapping("/list")
    @ResponseBody
    public List<Post> getPostList() {
        List<Post> postList = postService.findAll();
        return postList;
    }

    @GetMapping("/write")
    public String getPostWriteView(Model model) {

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "/posts/post_write";
    }

    @ResponseBody
    @PostMapping("/write") // POST:: /posts/write
    public PostEditDto postWrite(
            @RequestBody @Valid PostWriteRequest postWriteRequest,
            @AuthenticationPrincipal Account account
    ) {
        return postService.save(postWriteRequest, account);
    }

//    @GetMapping("/{id}")
//    public String getPost(
//            @PathVariable Long id,
//            Model model
//    ) {
//        Post findPost = postService.getById(id);
//        model.addAttribute("post", findPost); // Map<String, Object>
//        return "/posts/post_detail";
//    }

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

    @GetMapping("/delete/{id}")
    public String removeById(@PathVariable(name = "id") Long id) {
        postService.removeById(id);
        return "redirect:/";
    }

}

