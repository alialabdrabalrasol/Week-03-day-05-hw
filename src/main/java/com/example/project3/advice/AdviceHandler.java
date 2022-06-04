package com.example.project3.advice;

import com.example.project3.dto.ResponseAPI;
import com.example.project3.exception.InvalidIDException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(InvalidIDException.class)
    public ResponseEntity InvalidIDException(InvalidIDException e){
        String err_msg=e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseAPI(err_msg,HttpStatus.BAD_REQUEST.value()));
    }
}
