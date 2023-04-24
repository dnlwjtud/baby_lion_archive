package io.dnlwjtud.myBlog.global.config;

import io.dnlwjtud.myBlog.accounts.dto.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
            .and()
                .authorizeHttpRequests()
                    .requestMatchers("/posts/write")
                        .hasAnyRole(Role.ADMIN.getValue())
                    .requestMatchers("/posts/**")
                        .permitAll()
                    .requestMatchers("/admin/**")
                        .hasAnyRole(Role.ADMIN.getValue())
                    .anyRequest()
                        .permitAll()
            .and()
                // form 기반 로그인 설정
                .formLogin()
                // .loginPage() // login을 위한 페이지 주소 설정 (default : "/login")
    //                .loginProcessingUrl("/login.do") // 실제로 로그인이 수행될 주소 설정
    //                .usernameParameter("loginId") // form 태그 내부의 input 태그에서 username 데이터를 담고있는 name 프로퍼티 이름 기재
    //                .passwordParameter("loginPwd") // form 태그 내부의 input 태그에서 password 데이터를 담고있는 name 프로퍼티 이름 기재
                .defaultSuccessUrl("/") // 로그인 성공하고 나면, 디폴트로 이동 될 주소 ( 로그인 이전에 로그인이 필요한 페이지를 방문하지 아니하였을 때 )
//                .successForwardUrl("/member/info") // 성공시에 이동될 주소 ( 성공 후 Success Handler를 통과하여 )
//                .failureForwardUrl() // 로그인 실패 후 이동될 주소
            .and()
                // logout 설정
                .logout()
                    .clearAuthentication(true) // SecurityContextLogoutHandler가 로그아웃시 인증을 지워야 하는지에 대한 여부
                    .invalidateHttpSession(true) // 로그아웃시, HttpSession을 비활성화 하도록 SecurityContextLogoutHandler 구성하는 메서드
    //                .deleteCookies("") // 로그아웃 시 삭제할 쿠키의 이름을 나열
//                .logoutUrl() // 실제 로그아웃을 수행할 주소 설정
//                .logoutSuccessUrl("")// 로그아웃 된 다음 이동될 URL 설정
            .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
