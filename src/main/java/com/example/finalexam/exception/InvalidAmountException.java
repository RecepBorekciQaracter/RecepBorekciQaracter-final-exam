package com.example.finalexam.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
    public InvalidAmountException() {
        super("The requested amount is invalid");
    }
}
