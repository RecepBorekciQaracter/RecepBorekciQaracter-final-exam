package com.example.finalexam.exception;

public class InvalidIbanException extends RuntimeException {
    public InvalidIbanException(String message) {
        super(message);
    }
    public InvalidIbanException() {
        super("Invalid Iban. Iban should start with TR, followed by 24 digits.");
    }
}
