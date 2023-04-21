package io.dnlwjtud.myBlog.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Role {

    ADMIN("ADMIN"),
    MEMBER("MEMBER");

    private String value;

}
