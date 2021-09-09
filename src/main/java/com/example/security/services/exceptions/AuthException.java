package com.example.security.services.exceptions;

public class AuthException extends RuntimeException{
    public AuthException(String msg){
        super(msg);
    }
}
