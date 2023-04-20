package io.dnlwjtud.myBlog.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.stereotype.Controller;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
            .and()
                .authorizeHttpRequests()
                    .requestMatchers("/posts/**")
                        .permitAll() // FIXME: Role 구현 후 수정
                    .requestMatchers("/admin/**")
                        .permitAll() // FIXME: Role 구현 후 수정
                    .anyRequest()
                        .permitAll()
            .and()
                .build();
    }

}
