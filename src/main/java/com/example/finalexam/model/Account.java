package com.example.finalexam.model;

import com.example.finalexam.exception.InsufficientBalanceException;
import com.example.finalexam.exception.InvalidAmountException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Account {
    private Long id;
    private String ownerName;
    private String iban;
    private Double balance;
    private List<Transaction> transactions;

    public void deposit(Double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0.");
        }

        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, false);
        if (amount > 10000 )  {
            transaction.setFlagged(true);
        }
        transactions.add(transaction);
        balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0.");
        }

        if (amount > this.balance ) {
            throw new InsufficientBalanceException("Amount cannot be greater than balance");
        }

        Transaction transaction = new Transaction(TransactionType.WITHDRAW, amount, false);
        if (amount > 10000 )  {
            transaction.setFlagged(true);
        }
        transactions.add(transaction);
        balance -= amount;
    }

    public List<Transaction> getTransactions() {
        List<Transaction> sortedTransactions = new ArrayList<>(transactions);
        sortedTransactions.sort(Comparator.comparing(Transaction::getDate));
        return sortedTransactions;
    }

    public Account(String ownerName, String iban, Double balance) {
        this.ownerName = ownerName;
        this.iban = iban;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
