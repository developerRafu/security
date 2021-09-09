package com.example.security.resources.exceptions;

import com.example.security.services.exceptions.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResourceExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<StandartError> authException(AuthException e, HttpServletRequest request){
        StandartError err = new StandartError(e.getMessage(), HttpStatus.FORBIDDEN.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }
}
