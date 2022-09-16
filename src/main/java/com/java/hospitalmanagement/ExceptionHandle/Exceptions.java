package com.java.hospitalmanagement.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> runTimeExc(RuntimeException e){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
