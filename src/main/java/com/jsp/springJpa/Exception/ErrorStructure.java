package com.jsp.springJpa.Exception;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<T> {
    private String message;
    private int statusCode;
    private T rootCause;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getRootCause() {
        return rootCause;
    }

    public void setRootCause(T rootCause) {
        this.rootCause = rootCause;
    }
}
