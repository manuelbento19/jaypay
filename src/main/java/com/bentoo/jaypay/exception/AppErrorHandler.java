package com.bentoo.jaypay.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppErrorHandler {
    @ExceptionHandler(AppError.class)
    public ResponseEntity handler(AppError error){
        Map<String,String> exception = new HashMap<>();
        exception.put("error",error.getMessage());
        exception.put("status",String.valueOf(error.statusCode.value()));
        return ResponseEntity.status(error.statusCode).body(exception);
    }
}
