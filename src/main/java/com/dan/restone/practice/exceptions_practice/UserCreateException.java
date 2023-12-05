package com.dan.restone.practice.exceptions_practice;

public class UserCreateException extends RuntimeException{

    public UserCreateException(String message) {
        super(message);
    }
}
