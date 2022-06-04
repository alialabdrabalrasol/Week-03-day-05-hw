package com.example.project3.exception;


public class InvalidIDException extends RuntimeException{
    public InvalidIDException(String message) {
        super(message);
    }
}
