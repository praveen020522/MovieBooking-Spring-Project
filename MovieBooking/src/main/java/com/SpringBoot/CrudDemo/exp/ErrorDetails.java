package com.SpringBoot.CrudDemo.exp;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDetails {


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    private String message;
    private HttpStatus status;
    private LocalDateTime time;



}
