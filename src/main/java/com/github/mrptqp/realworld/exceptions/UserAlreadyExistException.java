package com.github.mrptqp.realworld.exceptions;


public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
