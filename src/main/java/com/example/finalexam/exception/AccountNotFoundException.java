package com.example.finalexam.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
    public AccountNotFoundException() {
        super("Requested Account Not Found");
    }
    public AccountNotFoundException(Long id) {
        super("Requested Account with id " + id + " Not Found");
    }
}
