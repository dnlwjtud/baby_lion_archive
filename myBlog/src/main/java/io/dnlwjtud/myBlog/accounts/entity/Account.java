package io.dnlwjtud.myBlog.accounts.entity;

import io.dnlwjtud.myBlog.accounts.dto.Role;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Entity
public class Account implements UserDetails {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // 계정
    private String password; // 비밀번호

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    private boolean accountExpiredStatus = false; // 계정 만료 여부
    private boolean lockedStatus = false; // 계정 잠김 여부
    private boolean credentialsExpiredStatus = false; // 비밀번호 만료 여부
    private boolean enableStatus = true; // 계정 활성화 여부

    @Override // 권한들 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                //.map(SimpleGrantedAuthority::new) -> Enum에서 값을 직접 가져올 수 없기 때문에 생성자에 할당할 수 없기 때문에 사용할 수 없음
                .map(
                        i -> new SimpleGrantedAuthority(i.getValue())
                ).toList();

    }

    @Override // 비밀번호 반환
    public String getPassword() {
        return this.password;
    }

    @Override // 계정(아이디) 반환
    public String getUsername() {
        return this.username;
    }

    @Override // 계정의 만료 여부
    public boolean isAccountNonExpired() {
        return !this.accountExpiredStatus;
    }


    @Override // 계정의 잠김 여부
    public boolean isAccountNonLocked() {
        return !this.lockedStatus;
    }


    @Override // 비밀번호 만료 여부
    public boolean isCredentialsNonExpired() {
        return !this.credentialsExpiredStatus;
    }

    @Override // 계정 활성화 여부
    public boolean isEnabled() {
        return this.enableStatus;
    }

}


