package io.dnlwjtud.myBlog.admin.service;


import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.accounts.service.AccountService;
import io.dnlwjtud.myBlog.categories.entity.Category;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import io.dnlwjtud.myBlog.posts.entity.Post;
import io.dnlwjtud.myBlog.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final PostService postService;
    private final AccountService accountService;
    private final CategoryService categoryService;

    public List<Post> getAllPost() {
        return postService.findAll();
    }

    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    public Account getAdmin() {
        return accountService.findById(1L);
    }

}
