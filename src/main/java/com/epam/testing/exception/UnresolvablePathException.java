package com.epam.testing.exception;

public class UnresolvablePathException extends RuntimeException {
    public UnresolvablePathException() {
    }

    public UnresolvablePathException(String message) {
        super(message);
    }

    public UnresolvablePathException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnresolvablePathException(Throwable cause) {
        super(cause);
    }
}
