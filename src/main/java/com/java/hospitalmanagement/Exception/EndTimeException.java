package com.java.hospitalmanagement.Exception;

public class EndTimeException extends RuntimeException{
    public EndTimeException(String message) {
        super(message);
    }

    public EndTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
