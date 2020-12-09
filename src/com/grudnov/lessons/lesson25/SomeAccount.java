package com.grudnov.lessons.lesson25;

public class SomeAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }
    // поток блокирует монитор объекта метод которого выполняется
    public synchronized void upBalance(int count) {
        balance += count;
    }
}
