package io.dnlwjtud.myBlog.global.config;

import io.dnlwjtud.myBlog.accounts.service.AccountService;
import io.dnlwjtud.myBlog.categories.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    @Bean
    CommandLineRunner initData(
            AccountService accountService,
            CategoryService categoryService
    ) {
        return args -> {
            accountService.initAccountData();
            categoryService.initCateData();
        };
    }


}
