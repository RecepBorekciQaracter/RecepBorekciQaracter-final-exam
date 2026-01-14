package com.example.finalexam.service;

import com.example.finalexam.exception.AccountNotFoundException;
import com.example.finalexam.exception.InvalidIbanException;
import com.example.finalexam.model.*;
import com.example.finalexam.repository.AccountRepository;
import com.example.finalexam.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public AccountEntity createAccount(CreateAccountRequest request) {
        if (accountRepository.existsByIban(request.getIban())) {
            throw new InvalidIbanException("Account with IBAN " + request.getIban() + " already exists");
        }

        Account account = new Account(request.getOwnerName(), request.getIban(), request.getBalance());

        AccountEntity accountEntity = toEntity(account);
        return accountRepository.save(accountEntity);
    }

    public AccountEntity getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public AccountEntity deposit(Long id, Double amount) {
        AccountEntity entity = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with ID " + id + " not found"));

        Account model = toModel(entity);

        model.deposit(amount);
        AccountEntity updated = toEntity(model);
        return accountRepository.save(updated);
    }

    public AccountEntity withdraw(Long id, Double amount) {
        AccountEntity entity = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with ID " + id + " not found"));

        Account model = toModel(entity);

        model.withdraw(amount);
        AccountEntity updated = toEntity(model);
        return accountRepository.save(updated);
    }

    public List<TransactionEntity> getTransactions(Long id) {
        return transactionRepository.findByAccountIdOrderByDateDesc(id);
    }


    // Get Entity Return Model
    private Account toModel(AccountEntity entity) {
        Account account = new Account(
                entity.getOwnerName(),
                entity.getIban(),
                entity.getBalance()
        );

        account.setId(entity.getId());

        List<Transaction> transactions = new ArrayList<>();

        for (TransactionEntity te : entity.getTransactions()) {
            Transaction transaction = new Transaction();
            transaction.setId(te.getId());
            transaction.setType(te.getType());
            transaction.setAmount(te.getAmount());
            transaction.setDate(te.getDate());
            transaction.setFlagged(te.getFlagged());

            transactions.add(transaction);
        }

        account.setTransactions(transactions);

        return account;
    }

    private AccountEntity toEntity(Account account) {
        AccountEntity entity = new AccountEntity();

        entity.setId(account.getId());
        entity.setOwnerName(account.getOwnerName());
        entity.setIban(account.getIban());
        entity.setBalance(account.getBalance());

        List<TransactionEntity> transactionEntities = new ArrayList<>();

        for (Transaction t : account.getTransactions()) {
            TransactionEntity te = new TransactionEntity();
            te.setType(t.getType());
            te.setAmount(t.getAmount());
            te.setDate(t.getDate());
            te.setFlagged(t.getFlagged());
            te.setAccount(entity);

            transactionEntities.add(te);
        }

        entity.setTransactions(transactionEntities);
        return entity;
    }

}
