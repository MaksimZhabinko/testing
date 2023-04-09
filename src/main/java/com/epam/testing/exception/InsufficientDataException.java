package com.epam.testing.exception;

public class InsufficientDataException extends RuntimeException {
    public InsufficientDataException() {
    }

    public InsufficientDataException(String message) {
        super(message);
    }

    public InsufficientDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientDataException(Throwable cause) {
        super(cause);
    }
}
