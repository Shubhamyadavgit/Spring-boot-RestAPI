package com.jsp.springJpa.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springJpa.Exception.ErrorStructure;
import com.jsp.springJpa.Exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationErrorHandler {

    @Autowired
    private ErrorStructure<String> structure;

    @ExceptionHandler(UserNotFoundException.class)

    public ResponseEntity<ErrorStructure<String>> handleUserNotFound(UserNotFoundException ux) {
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        structure.setMessage(ux.getMesssage());
        structure.setRootCause("No user found with this userId!!");
        return new ResponseEntity<ErrorStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }
}
