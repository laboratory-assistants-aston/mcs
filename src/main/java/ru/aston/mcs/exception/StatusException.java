package ru.aston.mcs.exception;

public class StatusException extends RuntimeException{
    public StatusException(Long id) {
        super(String.format("Resource %d is blocked now", id));
    }
}
