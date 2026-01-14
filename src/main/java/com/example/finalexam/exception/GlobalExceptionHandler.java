package com.example.finalexam.exception;

import com.example.finalexam.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAmountException(InvalidAmountException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidIbanException.class)
    public ResponseEntity<ErrorResponse> handleInvalidIbanException(InvalidIbanException e) {
        LocalDateTime timestamp = LocalDateTime.now();

        ErrorResponse error = new ErrorResponse(e.getMessage(), timestamp);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}