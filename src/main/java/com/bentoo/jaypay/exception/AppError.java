package com.bentoo.jaypay.exception;

import org.springframework.http.HttpStatusCode;

public class AppError extends RuntimeException{
    HttpStatusCode statusCode;
    public AppError(String message){
        super(message);
        this.statusCode = HttpStatusCode.valueOf(400);
    }
    public AppError(String message, Integer statusCode){
        super(message);
        this.statusCode = HttpStatusCode.valueOf(statusCode);
    }
}
