package io.dnlwjtud.myBlog.global.config;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.accounts.service.AccountService;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import io.dnlwjtud.myBlog.posts.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    @Bean
    CommandLineRunner initData(
            AccountService accountService,
            CategoryService categoryService,
            PostService postService
    ) {
        return args -> {
            Account account = accountService.initAccountData();
            categoryService.categoryInit();
            postService.postInit(account);
        };
    }


}
