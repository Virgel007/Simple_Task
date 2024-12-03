package org.example.councurrency.bank;


import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class BankAccount {
    private final AtomicReference<BigDecimal> totalCount = new AtomicReference<>(new BigDecimal(0));

    public void deposit(BigDecimal count) {
        BigDecimal currentValue = totalCount.get();
        BigDecimal newValue = currentValue.add(count);
        totalCount.set(newValue);
    }

    public void withdraw(BigDecimal count)  {
        BigDecimal currentValue = totalCount.get();
        if (currentValue.compareTo(count) < 0) {
            throw new InsufficientFundsException("Not enough money");
        }
        BigDecimal newValue = currentValue.subtract(count);
        totalCount.set(newValue);
    }

    public BigDecimal getBalance() {
        return totalCount.get();
    }
}
