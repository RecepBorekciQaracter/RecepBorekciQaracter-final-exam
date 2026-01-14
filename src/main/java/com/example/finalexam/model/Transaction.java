package com.example.finalexam.model;

import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private TransactionType type; // DEPOSIT or WITHDRAW
    private Double amount;
    private LocalDateTime date;
    private Boolean isFlagged;

    public Transaction() {
        this.date = LocalDateTime.now();
    }
    public Transaction(TransactionType type, Double amount, Boolean isFlagged) {
        this.type = type;
        this.amount = amount;
        this.isFlagged = isFlagged;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getFlagged() {
        return isFlagged;
    }

    public void setFlagged(Boolean flagged) {
        isFlagged = flagged;
    }
}
