package com.example.finalexam.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
    public InsufficientBalanceException() {
        super("You do not have enough balance");
    }
}
