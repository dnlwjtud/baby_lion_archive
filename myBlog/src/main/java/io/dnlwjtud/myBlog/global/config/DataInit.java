package io.dnlwjtud.myBlog.global.config;

import io.dnlwjtud.myBlog.accounts.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    @Bean
    CommandLineRunner initData(
            AccountService accountService
    ) {
        return args -> {
            accountService.initAccountData();
        };
    }


}
