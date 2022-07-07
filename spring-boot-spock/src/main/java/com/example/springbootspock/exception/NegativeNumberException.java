package com.example.springbootspock.exception;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException() {
        super();
    }

    public NegativeNumberException(String message) {
        super(message);
    }

    public NegativeNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeNumberException(Throwable cause) {
        super(cause);
    }

}
