package net.pao.temaSpringBoot.model.controller;


import net.pao.temaSpringBoot.model.Account;
import net.pao.temaSpringBoot.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account-id/{id}")
    public Optional<Account> getById(@PathVariable(name = "id") UUID id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/create-account")
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping("/update-account/{id}")
    public void updateAccount(@PathVariable(name = "id") UUID id, @RequestBody Account account) {
        account.setAccountId(id);
        accountService.updateAccount(account);
    }

    @DeleteMapping("/delete-account/{id}")
    public void deleteAccount(@PathVariable(name = "id") UUID id) {
        accountService.deleteAccount(id);
    }

    @PatchMapping("/update-account-balance/{id}")
    public void updateAccountBalance(@PathVariable(name = "id") UUID id, @RequestBody Account account) {
        Optional<Account> existingAccount = accountService.getAccountById(id);

        if(account.getBalance() != null) {
            existingAccount.get().setBalance(account.getBalance());
        }

        accountService.updateAccount(existingAccount.get());
    }
}
