package com.SpringBoot.CrudDemo.exp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AppExpHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorDetails handler(NoSuchElementException ex){
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setStatus(HttpStatus.NOT_FOUND);
        errorDetails.setTime(LocalDateTime.now());
        return errorDetails;


    }
    @ExceptionHandler(RuntimeException.class)
    public ErrorDetails runHandler(RuntimeException ex){
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setStatus(HttpStatus.NOT_FOUND);
        errorDetails.setTime(LocalDateTime.now());
        return errorDetails;


    }
}
