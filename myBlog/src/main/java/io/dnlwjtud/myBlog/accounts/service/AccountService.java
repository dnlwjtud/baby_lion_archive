package io.dnlwjtud.myBlog.accounts.service;

import io.dnlwjtud.myBlog.accounts.dto.AccountCreateDto;
import io.dnlwjtud.myBlog.accounts.dto.Role;
import io.dnlwjtud.myBlog.accounts.entity.Account;
import io.dnlwjtud.myBlog.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Account initAccountData() {

        AccountCreateDto accountCreateDto = new AccountCreateDto("admin", passwordEncoder.encode("admin"), "관리자");
        Account account = Account.createAccount(accountCreateDto);

        account.appendRole(Role.ADMIN);

        return accountRepository.save(account);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> accountOptional = accountRepository.findByUsername(username);

        if ( accountOptional.isPresent() ) {
            return accountOptional.get();
        }

        return null;

    }

    public Account findById(Long id) {

        Optional<Account> accountOptional = accountRepository.findById(id);

        if ( accountOptional.isPresent() ) {
            return accountOptional.get();
        }

        return null;

    }




}
