package com.java.hospitalmanagement.ExceptionHandle;

import com.java.hospitalmanagement.Exception.AppointmentException;
import com.java.hospitalmanagement.Exception.TimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> runTimeExc(RuntimeException e){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> endTimeExc(TimeException e){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> appointmentExc(AppointmentException e){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
