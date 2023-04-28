package io.dnlwjtud.myBlog.accounts.controller;

import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
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
        // principal.getName(); // username 반환!
        Account account = accountService.updateNickname(principal.getName(), nickname);
        return account.getNickname();
    }

    @ResponseBody
    @PostMapping("/adms/accounts/update/pwd")
    public String updatePassword(
            @RequestBody String rawPassword,
            Principal principal
    ) {
        Account account = accountService.updatePassword(principal.getName(), rawPassword);
        return account.getNickname();
    }


}
