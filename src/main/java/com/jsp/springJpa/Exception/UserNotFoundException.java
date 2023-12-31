package com.jsp.springJpa.Exception;


public class UserNotFoundException extends RuntimeException {
    private String messsage;

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    @Override
    public String toString() {
        return "UserNotFoundException [messsage=" + messsage + "]";
    }

    public UserNotFoundException(String messsage) {
        this.messsage = messsage;
    }
}
