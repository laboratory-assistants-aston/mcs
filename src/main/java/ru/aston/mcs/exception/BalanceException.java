package ru.aston.mcs.exception;

public class BalanceException extends RuntimeException{
    public BalanceException() {
        super("Balance is not enough ");
    }
}
