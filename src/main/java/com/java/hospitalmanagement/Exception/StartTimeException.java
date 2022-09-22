package com.java.hospitalmanagement.Exception;

public class StartTimeException extends RuntimeException{
    public StartTimeException(String message) {
        super(message);
    }

    public StartTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
