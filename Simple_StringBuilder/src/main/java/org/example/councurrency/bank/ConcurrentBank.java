package org.example.councurrency.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * В виртуальном банке "ConcurrentBank" решено внедрить многопоточность для обработки операций по счетам клиентов.
 * Система должна поддерживать возможность одновременного пополнения (deposit),
 * снятия (withdraw), а также переводов (transfer) между счетами. Каждый счет имеет свой уникальный номер.
 *
 * Реализуйте класс BankAccount с методами deposit, withdraw и getBalance,
 * поддерживающими многопоточное взаимодействие.
 *
 * Реализуйте класс ConcurrentBank для управления счетами и выполнения переводов между ними.
 * Класс должен предоставлять методы createAccount для создания нового счета и transfer для выполнения переводов между счетами.
 *
 * Переводы между счетами должны быть атомарными, чтобы избежать ситуаций,
 * когда одна часть транзакции выполняется успешно, а другая нет.
 *
 * Реализуйте метод getTotalBalance, который возвращает общий баланс всех счетов в банке.
 */

public class ConcurrentBank {

    ReentrantLock lock = new ReentrantLock();
    private final List<BankAccount> accounts = new CopyOnWriteArrayList<>(); // использовать CopyOnWriteArrayList для параллельной обработки

    public BankAccount createAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        BankAccount account = new BankAccount();
        account.deposit(new BigDecimal(initialBalance));
        accounts.add(account);
        return account;
    }

    public void transfer(BankAccount account1, BankAccount account2, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Сумма перевода не может быть отрицательной");
        }
        try(AutoCloseableLock lock = new AutoCloseableLock(this.lock)) {
            BigDecimal bigDecimal = new BigDecimal(count);
            account1.withdraw(bigDecimal);
            account2.deposit(bigDecimal);
        }
    }

    public String getTotalBalance() {
        return accounts.parallelStream() // использовать параллельную обработку
                .map(BankAccount::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .toString();
    }
}

class AutoCloseableLock implements AutoCloseable {

    private final ReentrantLock lock;

    public AutoCloseableLock(ReentrantLock lock) {
        this.lock = lock;
        lock.lock();
    }

    @Override
    public void close() {
        lock.unlock();
    }
}