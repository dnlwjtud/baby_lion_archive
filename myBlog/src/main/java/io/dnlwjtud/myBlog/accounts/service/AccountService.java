package io.dnlwjtud.myBlog.accounts.service;

import io.dnlwjtud.myBlog.accounts.dto.AccountCreateDto;
import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Transactional
    public void initAccountData() {


        new AccountCreateDto();
        Account.createAccount();

        accountRepository.save()

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> accountOptional = accountRepository.findByUsername(username);

        if ( accountOptional.isPresent() ) {
            return accountOptional.get();
        }

        return null;

    }




}
