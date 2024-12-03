package org.example.councurrency.bank;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String notEnoughMoney) {
        super(notEnoughMoney);
    }
}
