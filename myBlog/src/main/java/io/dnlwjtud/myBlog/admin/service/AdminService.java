package io.dnlwjtud.myBlog.admin.service;

import io.dnlwjtud.myBlog.accounts.service.AccountService;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import io.dnlwjtud.myBlog.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AccountService accountService;
    private final PostService postService;
    private final CategoryService categoryService;




}
