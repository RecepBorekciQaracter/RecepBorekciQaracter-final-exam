package com.example.finalexam.controller;

import com.example.finalexam.model.AccountEntity;
import com.example.finalexam.model.CreateAccountRequest;
import com.example.finalexam.model.TransactionEntity;
import com.example.finalexam.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountEntity createAccount(@Valid @RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping("/{id}")
    public AccountEntity getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/{id}/deposit")
    public AccountEntity deposit(@RequestParam Double amount, @PathVariable Long id) {
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public AccountEntity withdraw(@RequestParam Double amount, @PathVariable Long id) {
        return accountService.withdraw(id, amount);
    }

    @GetMapping("/{id}/getTransactions")
    public List<TransactionEntity> getTransactions(@PathVariable Long id) {
        return accountService.getTransactions(id);
    }

}
