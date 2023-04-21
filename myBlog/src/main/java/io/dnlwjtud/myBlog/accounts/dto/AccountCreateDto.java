package io.dnlwjtud.myBlog.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDto {

    private String username;
    private String password;

    private String nickname;

}
