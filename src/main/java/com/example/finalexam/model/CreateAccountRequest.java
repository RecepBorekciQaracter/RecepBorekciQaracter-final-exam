package com.example.finalexam.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateAccountRequest {

    @NotBlank
    private String ownerName;
    @NotBlank
    @Pattern(regexp = "^ES\\d{22}$")
    private String iban;
    @Min(0)
    private Double balance;



    public String getOwnerName() {
        return ownerName;
    }

    public String getIban() {
        return iban;
    }

    public Double getBalance() {
        return balance;
    }
}
