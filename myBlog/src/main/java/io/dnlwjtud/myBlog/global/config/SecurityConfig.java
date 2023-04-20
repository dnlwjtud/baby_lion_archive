package io.dnlwjtud.myBlog.global.config;

import io.dnlwjtud.myBlog.accounts.dto.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
            .and()
                // /posts/ , /admin/
                .authorizeHttpRequests()
                    .requestMatchers("/posts/**")
                        .permitAll() // FIXME: Role 구현 후 수정
                    .requestMatchers("/admin/**")
                        .hasRole(Role.ADMIN.getValue())
//                        .permitAll() // FIXME: Role 구현 후 수정
                    .anyRequest()
                        .permitAll()
//                        .denyAll() 모든 접근에 대해서 비공개처리
            .and()
                .build();
    }

}
