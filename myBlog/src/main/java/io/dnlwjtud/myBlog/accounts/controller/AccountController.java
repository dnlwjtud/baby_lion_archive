package io.dnlwjtud.myBlog.accounts.controller;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @ResponseBody
    @PostMapping("/adms/accounts/update/nickname")
    public String updateNickname(
            @RequestBody String nickname,
            Principal principal
    ) {
        return accountService.updateNickname(principal.getName(), nickname).getNickname();
    }

    @ResponseBody
    @PostMapping("/adms/accounts/update/pwd")
    public String updatePwd(
            @RequestBody String rawPassword,
            Principal principal
    ) {
        System.out.println("rawPassword = " + rawPassword);
        return accountService.updatePassword(principal.getName(), rawPassword).getNickname();
    }


}
